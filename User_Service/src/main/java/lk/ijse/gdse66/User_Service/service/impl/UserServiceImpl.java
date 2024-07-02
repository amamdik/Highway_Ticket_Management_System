package lk.ijse.gdse66.User_Service.service.impl;

import lk.ijse.gdse66.User_Service.conversion.Conversion;
import lk.ijse.gdse66.User_Service.dto.UserDTO;
import lk.ijse.gdse66.User_Service.repo.UserServiceDAO;
import lk.ijse.gdse66.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private Conversion conversion;

    @Autowired
    private UserServiceDAO userServiceDAO;

    @Override
    public void save(UserDTO userDTO) {
        userServiceDAO.save(conversion.convertToEntity(userDTO));
    }

    @Override
    public boolean isExistsUser(String user_id) {
        return userServiceDAO.existsById(user_id);
    }

    @Override
    public boolean checkCredentials(UserDTO userDTO) {
        return userServiceDAO.existsByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
    }
}
