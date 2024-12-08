package ca.gbc.bookingservice.controller;

import ca.gbc.bookingservice.service.BookingEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingEventPublisher eventPublisher;

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmBooking(@RequestBody String bookingDetails) {
        // Publish booking details to Kafka
        eventPublisher.publishBookingEvent(bookingDetails);
        return ResponseEntity.ok("Booking confirmed and event published.");
    }
}
