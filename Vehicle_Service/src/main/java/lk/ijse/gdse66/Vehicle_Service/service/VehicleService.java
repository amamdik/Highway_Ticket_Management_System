package lk.ijse.gdse66.Vehicle_Service.service;

import lk.ijse.gdse66.Vehicle_Service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void save(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAll();
    boolean isExistsUser(String user_id);
    boolean isExistsVehicle(String vehicle_id);
}
