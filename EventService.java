package com.examly.demo.Service;

import com.examly.demo.Model.Event;
import com.examly.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    // Create Event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get All Events with Pagination & Sorting
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    // Get Event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Find Events by Location
    public List<Event> findEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    // Find Upcoming Events
    public List<Event> findUpcomingEvents(LocalDateTime dateTime) {
        return eventRepository.findUpcomingEvents(dateTime);
    }

    // Count Events at a Location
    public Long countEventsByLocation(String location) {
        return eventRepository.countByLocation(location);
    }

    // Update Event Name
    @Transactional
    public int updateEventName(Long id, String name) {
        return eventRepository.updateEventName(id, name);
    }

    // Update Event Location
    @Transactional
    public int updateEventLocation(Long id, String location) {
        return eventRepository.updateEventLocation(id, location);
    }

    // Delete Event by ID
    @Transactional
    public void deleteEventById(Long id) {
        eventRepository.deleteEventById(id);
    }
}
