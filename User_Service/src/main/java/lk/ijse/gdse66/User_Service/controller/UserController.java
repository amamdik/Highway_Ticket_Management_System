package lk.ijse.gdse66.User_Service.controller;

import lk.ijse.gdse66.User_Service.dto.UserDTO;
import lk.ijse.gdse66.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok("User saved successfully");
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<?> checkCredentials(@RequestBody UserDTO userDTO) {
        if (userService.checkCredentials(userDTO)) {
            return ResponseEntity.ok("User exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok("User updated successfully");
    }
}
