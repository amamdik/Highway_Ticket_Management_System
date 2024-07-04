package lk.ijse.gdse66.Payment_Service.conversion;

import lk.ijse.gdse66.Payment_Service.dto.PaymentDTO;
import lk.ijse.gdse66.Payment_Service.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Conversion {

    private final ModelMapper modelMapper;

    public PaymentEntity convertToEntity(PaymentDTO ticketDTO){
        return modelMapper.map(ticketDTO, PaymentEntity.class);
    }

    public List<PaymentDTO> convertToDTOs(List<PaymentEntity> tickets){
        return modelMapper.map(tickets, List.class);
    }
}
