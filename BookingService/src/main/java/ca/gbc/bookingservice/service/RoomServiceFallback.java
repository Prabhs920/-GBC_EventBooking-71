package ca.gbc.bookingservice.service;

import org.springframework.stereotype.Component;

@Component
public class RoomServiceFallback implements RoomServiceClient {

    @Override
    public Boolean checkRoomAvailability(String roomId) {
        // Provide a default response if RoomService is down
        return false; // Assume the room is unavailable
    }
}
