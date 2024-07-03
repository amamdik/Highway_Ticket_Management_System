package lk.ijse.gdse66.Vehicle_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicle_id;
    private String model;
    private String colour;
    private String brand;
    private String user_id;
}
