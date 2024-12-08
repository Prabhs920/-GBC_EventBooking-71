package ca.gbc.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingEventPublisher {

    private static final String TOPIC = "booking-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishBookingEvent(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
