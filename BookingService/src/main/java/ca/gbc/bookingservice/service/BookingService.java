package ca.gbc.bookingservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "roomServiceCircuitBreaker", fallbackMethod = "roomServiceFallback")
    public boolean checkRoomAvailability(String roomId) {
        String url = "http://RoomService/api/rooms/" + roomId + "/availability";
        return restTemplate.getForObject(url, Boolean.class);
    }

    public boolean roomServiceFallback(String roomId, Throwable throwable) {
        // Fallback response in case RoomService is down
        System.err.println("RoomService is unavailable. Returning default value.");
        return false; // Default to room unavailable
    }
}
