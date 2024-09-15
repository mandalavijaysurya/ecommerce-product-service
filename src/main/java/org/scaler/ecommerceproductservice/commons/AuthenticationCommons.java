package org.scaler.ecommerceproductservice.commons;

import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Component
public class AuthenticationCommons {

    public final RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String token){
        if(token == null){
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange("http://localhost:8080/auth/validate",
                HttpMethod.POST, new HttpEntity<>(headers), new ParameterizedTypeReference<UserDTO>() {
                });
        return responseEntity.getBody();
    }
}
