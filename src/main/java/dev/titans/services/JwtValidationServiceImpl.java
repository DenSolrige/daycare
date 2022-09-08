package dev.titans.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JwtValidationServiceImpl implements JwtValidationService{

    @Override
    public boolean validateJwt(String jwt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestBody = new HttpEntity<>(jwt);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:7070/validate", HttpMethod.POST,requestBody, String.class);
        return responseEntity.getBody().equals("SUCCESS");
    }
}
