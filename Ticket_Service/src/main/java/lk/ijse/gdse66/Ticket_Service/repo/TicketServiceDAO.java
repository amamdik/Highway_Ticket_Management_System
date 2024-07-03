package lk.ijse.gdse66.Ticket_Service.repo;

import lk.ijse.gdse66.Ticket_Service.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketServiceDAO extends JpaRepository<TicketEntity, String> {
}
