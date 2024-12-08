package ca.gbc.eventservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventConsumer {

    @KafkaListener(topics = "booking-events", groupId = "event-service-group")
    public void consumeBookingEvent(String bookingDetails) {
        System.out.println("Received Booking Event: " + bookingDetails);

        // Logic to handle the event (e.g., save to database, process data, etc.)
        // For now, we will simply log the event.
    }
}
