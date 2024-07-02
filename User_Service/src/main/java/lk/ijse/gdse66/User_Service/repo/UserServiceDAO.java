package lk.ijse.gdse66.User_Service.repo;

import lk.ijse.gdse66.User_Service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceDAO extends JpaRepository<UserEntity, String> {
    boolean existsByEmailAndPassword(String email, String password);
}
