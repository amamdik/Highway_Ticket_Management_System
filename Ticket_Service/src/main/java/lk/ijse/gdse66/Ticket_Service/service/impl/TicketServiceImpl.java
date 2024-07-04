package lk.ijse.gdse66.Ticket_Service.service.impl;

import lk.ijse.gdse66.Ticket_Service.Enum.TicketStatus;
import lk.ijse.gdse66.Ticket_Service.conversion.Conversion;
import lk.ijse.gdse66.Ticket_Service.dto.TicketDTO;
import lk.ijse.gdse66.Ticket_Service.entity.TicketEntity;
import lk.ijse.gdse66.Ticket_Service.repo.TicketServiceDAO;
import lk.ijse.gdse66.Ticket_Service.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketServiceDAO ticketServiceDAO;
    @Autowired
    private Conversion conversion;

    private final RestTemplate restTemplate;

    @Override
    public void save(TicketDTO ticketDTO) {
        ticketServiceDAO.save(conversion.convertToEntity(ticketDTO));
    }

    @Override
    public void updateStatus(String ticket_id) {
        Optional<TicketEntity> byId = ticketServiceDAO.findById(ticket_id);
        if (byId.isPresent()) {
            TicketEntity ticket = byId.get();
            ticket.setStatus(TicketStatus.PAID);
            ticketServiceDAO.save(ticket);
        }
    }

    @Override
    public List<TicketDTO> getAll() {
        return conversion.convertToDTOs(ticketServiceDAO.findAll());
    }

    @Override
    public boolean isExistsUser(String user_id) {
        String url = "http://User-Service/api/v1/user/existUser/" + user_id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsVehicle(String vehicle_id) {
        String url = "http://Vehicle_Service/api/v1/vehicle/existVehicle/" + vehicle_id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsTicket(String ticket_id) {
        return ticketServiceDAO.existsById(ticket_id);
    }
}
