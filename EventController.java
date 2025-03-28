package com.examly.demo.Controller;

import com.examly.demo.Model.Event;
import com.examly.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create Event
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.saveEvent(event));
    }

    // Get All Events with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Event>> getAllEvents(Pageable pageable) {
        return ResponseEntity.ok(eventService.getAllEvents(pageable));
    }

    // Get Event by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    // Find Events by Location
    @GetMapping("/search/location/{location}")
    public ResponseEntity<List<Event>> findEventsByLocation(@PathVariable String location) {
        return ResponseEntity.ok(eventService.findEventsByLocation(location));
    }

    // Find Upcoming Events
    @GetMapping("/search/upcoming/{dateTime}")
    public ResponseEntity<List<Event>> findUpcomingEvents(@PathVariable LocalDateTime dateTime) {
        return ResponseEntity.ok(eventService.findUpcomingEvents(dateTime));
    }

    // Count Events at a Location
    @GetMapping("/count/location/{location}")
    public ResponseEntity<Long> countEventsByLocation(@PathVariable String location) {
        return ResponseEntity.ok(eventService.countEventsByLocation(location));
    }

    // Update Event Name
    @PutMapping("/update/name/{id}")
    public ResponseEntity<Integer> updateEventName(@PathVariable Long id, @RequestBody String name) {
        return ResponseEntity.ok(eventService.updateEventName(id, name));
    }

    // Update Event Location
    @PutMapping("/update/location/{id}")
    public ResponseEntity<Integer> updateEventLocation(@PathVariable Long id, @RequestBody String location) {
        return ResponseEntity.ok(eventService.updateEventLocation(id, location));
    }

    // Delete Event by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }
}
