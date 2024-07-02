package lk.ijse.gdse66.User_Service.service;

import lk.ijse.gdse66.User_Service.dto.UserDTO;

public interface UserService {
    void save(UserDTO userDTO);
    boolean isExistsUser(String user_id);
    boolean checkCredentials(UserDTO userDTO);
}
