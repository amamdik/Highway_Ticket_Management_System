package lk.ijse.gdse66.Ticket_Service.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.Ticket_Service.Enum.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    private String ticket_id;
    private String vehicle_id;
    private String user_id;
    private Date issueDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
