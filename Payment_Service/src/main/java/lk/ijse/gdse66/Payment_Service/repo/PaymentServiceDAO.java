package lk.ijse.gdse66.Payment_Service.repo;

import lk.ijse.gdse66.Payment_Service.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentServiceDAO extends JpaRepository<PaymentEntity, String> {
}
