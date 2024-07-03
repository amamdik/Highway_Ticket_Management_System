package lk.ijse.gdse66.Vehicle_Service.controller;

import lk.ijse.gdse66.Vehicle_Service.dto.VehicleDTO;
import lk.ijse.gdse66.Vehicle_Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getAllVehicles")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/existVehicle/{vehicle_id}")
    public ResponseEntity<?> existVehicle(@PathVariable String vehicle_id) {
        if (vehicleService.isExistsVehicle(vehicle_id)){
            return ResponseEntity.ok("Vehicle exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle does not exist");
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleService.isExistsUser(vehicleDTO.getUser_id())) {
            vehicleService.save(vehicleDTO);
            return ResponseEntity.ok("Vehicle saved successfully");
        }else {
            return ResponseEntity.ok("User does not exists");
        }
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.save(vehicleDTO);
        return ResponseEntity.ok("Vehicle updated successfully");
    }
}
