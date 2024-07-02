package lk.ijse.gdse66.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String user_id;
    private String user_name;
    private String email;
    private String password;
    private String role;
}
