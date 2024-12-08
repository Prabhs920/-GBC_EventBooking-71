package ca.gbc.bookingservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RoomServiceClient", url = "${ROOM_SERVICE_URL:http://localhost:8085}", fallback = RoomServiceFallback.class)
public interface RoomServiceClient {

    @GetMapping("/api/rooms/check-availability")
    @CircuitBreaker(name = "roomServiceCircuitBreaker", fallbackMethod = "fallbackCheckRoomAvailability")
    Boolean checkRoomAvailability(@RequestParam("roomId") String roomId);
}
