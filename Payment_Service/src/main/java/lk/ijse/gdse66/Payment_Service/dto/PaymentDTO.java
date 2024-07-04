package lk.ijse.gdse66.Payment_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String payment_id;
    private double amount;
    private Date payment_date;
    private String ticket_id;
    private String user_id;
}
