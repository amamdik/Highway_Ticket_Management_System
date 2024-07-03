package lk.ijse.gdse66.Vehicle_Service.conversion;

import lk.ijse.gdse66.Vehicle_Service.dto.VehicleDTO;
import lk.ijse.gdse66.Vehicle_Service.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper modelMapper;

    public VehicleEntity convertToEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }

    public List<VehicleDTO> convertToDTOs(List<VehicleEntity> vehicles){
        return modelMapper.map(vehicles, List.class);
    }
}
