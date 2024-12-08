package ca.gbc.eventservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events") // This sets the collection name to "events" in MongoDB
public class Event {
    @Id
    private String id; // MongoDB uses a String as the id type
    private String eventName;
    private String organizerId; // This links to the organizer (like a user ID)
    private String eventType;
    private int expectedAttendees;
}
