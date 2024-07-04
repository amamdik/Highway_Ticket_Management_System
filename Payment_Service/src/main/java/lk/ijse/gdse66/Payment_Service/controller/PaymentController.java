package lk.ijse.gdse66.Payment_Service.controller;

import lk.ijse.gdse66.Payment_Service.dto.PaymentDTO;
import lk.ijse.gdse66.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PaymentDTO paymentDTO) {
        if (paymentService.isExistsUser(paymentDTO.getUser_id())) {
            if (paymentService.isExistsTicket(paymentDTO.getTicket_id())) {
                paymentService.save(paymentDTO);
                return ResponseEntity.ok("Payment saved successfully");
            }else {
                return ResponseEntity.ok("Ticket does not exists");
            }
        }else {
            return ResponseEntity.ok("User does not exists");
        }
    }
}
