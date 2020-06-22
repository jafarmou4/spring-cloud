package com.example.guestserviceribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RibbonClient("GUEST-SERVICE")
public class GuestController {
    private final RestTemplate restTemplate;

    public GuestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ribbon-guests")
    public List<Guest> getAllGuests() {
        return getGuests();
    }

    private List<Guest> getGuests() {
        ResponseEntity<List<Guest>> result = this.restTemplate.exchange("http://GUEST-SERVICE/guests", HttpMethod.GET, null, new ParameterizedTypeReference<List<Guest>>() {});
        return result.getBody();
    }
}
