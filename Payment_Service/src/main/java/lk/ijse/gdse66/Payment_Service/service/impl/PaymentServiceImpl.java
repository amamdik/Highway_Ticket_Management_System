package lk.ijse.gdse66.Payment_Service.service.impl;

import lk.ijse.gdse66.Payment_Service.conversion.Conversion;
import lk.ijse.gdse66.Payment_Service.dto.PaymentDTO;
import lk.ijse.gdse66.Payment_Service.repo.PaymentServiceDAO;
import lk.ijse.gdse66.Payment_Service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentServiceDAO paymentServiceDAO;

    @Autowired
    private Conversion conversion;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void save(PaymentDTO paymentDTO) {
        setPaidStatus(paymentDTO.getTicket_id());
        paymentServiceDAO.save(conversion.convertToEntity(paymentDTO));
    }

    private void setPaidStatus(String ticket_id) {
        String url = "http://Ticket_Service/api/v1/ticket/updateStatus/" + ticket_id;
        restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
    }

    @Override
    public boolean isExistsUser(String user_id) {
        String url = "http://User_Service/api/v1/user/existUser/" + user_id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsTicket(String ticket_id) {
        String url = "http://Ticket_Service/api/v1/ticket/existTicket/" + ticket_id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
