package ca.gbc.eventservice.service;

import ca.gbc.eventservice.model.Event;
import ca.gbc.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(String id, Event eventDetails) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setEventName(eventDetails.getEventName());
                    event.setOrganizerId(eventDetails.getOrganizerId());
                    event.setEventType(eventDetails.getEventType());
                    event.setExpectedAttendees(eventDetails.getExpectedAttendees());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
