package lk.ijse.gdse66.Payment_Service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    private String payment_id;
    private double amount;
    private Date payment_date;
    private String ticket_id;
    private String user_id;
}
