package lk.ijse.gdse66.Ticket_Service.dto;

import lk.ijse.gdse66.Ticket_Service.Enum.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private String ticket_id;
    private String vehicle_id;
    private String user_id;
    private Date issueDate;
    private TicketStatus status;
}
