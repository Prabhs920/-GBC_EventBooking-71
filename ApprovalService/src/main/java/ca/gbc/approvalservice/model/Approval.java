package ca.gbc.approvalservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "approvals") // MongoDB collection name
public class Approval {
    @Id
    private String id; // Unique ID for each approval
    private String eventId; // ID of the event being approved
    private String reviewerId; // ID of the staff member reviewing
    private String status; // "approved" or "rejected"
    private String notes; // Any additional notes by the reviewer

    // Constructors, getters, and setters (use Lombok if you prefer)
    public Approval() {}

    public Approval(String eventId, String reviewerId, String status, String notes) {
        this.eventId = eventId;
        this.reviewerId = reviewerId;
        this.status = status;
        this.notes = notes;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getReviewerId() { return reviewerId; }
    public void setReviewerId(String reviewerId) { this.reviewerId = reviewerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
