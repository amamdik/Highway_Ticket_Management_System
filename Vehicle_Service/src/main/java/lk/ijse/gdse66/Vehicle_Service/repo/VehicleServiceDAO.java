package lk.ijse.gdse66.Vehicle_Service.repo;

import lk.ijse.gdse66.Vehicle_Service.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceDAO extends JpaRepository<VehicleEntity, String> {
}
