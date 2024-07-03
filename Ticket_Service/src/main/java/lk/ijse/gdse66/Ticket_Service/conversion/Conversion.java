package lk.ijse.gdse66.Ticket_Service.conversion;

import lk.ijse.gdse66.Ticket_Service.dto.TicketDTO;
import lk.ijse.gdse66.Ticket_Service.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper modelMapper;

    public TicketEntity convertToEntity(TicketDTO ticketDTO){
        return modelMapper.map(ticketDTO, TicketEntity.class);
    }

    public List<TicketDTO> convertToDTOs(List<TicketEntity> tickets){
        return modelMapper.map(tickets, List.class);
    }
}
