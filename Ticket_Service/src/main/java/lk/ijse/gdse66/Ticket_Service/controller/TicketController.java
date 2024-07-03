package lk.ijse.gdse66.Ticket_Service.controller;

import lk.ijse.gdse66.Ticket_Service.Enum.TicketStatus;
import lk.ijse.gdse66.Ticket_Service.dto.TicketDTO;
import lk.ijse.gdse66.Ticket_Service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/existTicket/{ticket_id}")
    public ResponseEntity<?> existTicket(@PathVariable String ticket_id) {
        if (ticketService.isExistsTicket(ticket_id)){
            return ResponseEntity.ok("Ticket exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket does not exist");
        }
    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody TicketDTO ticketDTO) {
        ticketDTO.setStatus(TicketStatus.UNPAID);
        if (ticketService.isExistsUser(ticketDTO.getUser_id())) {
            if (ticketService.isExistsVehicle(ticketDTO.getVehicle_id())) {
                ticketService.save(ticketDTO);
                return ResponseEntity.ok("Ticket saved successfully");
            }else {
                return ResponseEntity.ok("Vehicle does not exists");
            }
        }else {
            return ResponseEntity.ok("User does not exists");
        }
    }

    @PutMapping("/updateStatus/{ticket_id}")
    public ResponseEntity<?> updateStatus(@PathVariable String ticket_id) {
        ticketService.updateStatus(ticket_id);
        return ResponseEntity.ok("Ticket Status updated successfully");
    }
}
