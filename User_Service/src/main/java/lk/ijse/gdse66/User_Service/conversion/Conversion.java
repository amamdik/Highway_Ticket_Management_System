package lk.ijse.gdse66.User_Service.conversion;

import lk.ijse.gdse66.User_Service.dto.UserDTO;
import lk.ijse.gdse66.User_Service.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper modelMapper;

    public UserEntity convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
