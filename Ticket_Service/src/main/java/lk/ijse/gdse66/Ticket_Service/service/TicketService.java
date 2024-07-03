package lk.ijse.gdse66.Ticket_Service.service;

import lk.ijse.gdse66.Ticket_Service.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    void save(TicketDTO ticketDTO);
    void updateStatus(String ticket_id);
    List<TicketDTO> getAll();
    boolean isExistsUser(String user_id);
    boolean isExistsVehicle(String vehicle_id);
    boolean isExistsTicket(String ticket_id);
}
