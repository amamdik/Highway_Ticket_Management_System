package lk.ijse.gdse66.Vehicle_Service.service.impl;

import lk.ijse.gdse66.Vehicle_Service.conversion.Conversion;
import lk.ijse.gdse66.Vehicle_Service.dto.VehicleDTO;
import lk.ijse.gdse66.Vehicle_Service.repo.VehicleServiceDAO;
import lk.ijse.gdse66.Vehicle_Service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleServiceDAO vehicleServiceDAO;
    private final RestTemplate restTemplate;

    @Autowired
    private Conversion conversion;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        vehicleServiceDAO.save(conversion.convertToEntity(vehicleDTO));
    }

    @Override
    public List<VehicleDTO> getAll() {
        return conversion.convertToDTOs(vehicleServiceDAO.findAll());
    }

    @Override
    public boolean isExistsUser(String user_id) {
        String url = "http://user-service/api/v1/user/existUser/" + user_id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

            if (response.getStatusCode() == HttpStatus.OK){
                return true;
            }else {
                return false;
            }
        }catch (HttpClientErrorException e){
            return false;
        }
    }

    @Override
    public boolean isExistsVehicle(String vehicle_id) {
        return vehicleServiceDAO.existsById(vehicle_id);
    }
}
