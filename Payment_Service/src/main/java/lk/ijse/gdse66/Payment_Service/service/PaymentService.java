package lk.ijse.gdse66.Payment_Service.service;

import lk.ijse.gdse66.Payment_Service.dto.PaymentDTO;

public interface PaymentService {
    void save(PaymentDTO paymentDTO);
    boolean isExistsUser(String user_id);
    boolean isExistsTicket(String ticket_id);
}
