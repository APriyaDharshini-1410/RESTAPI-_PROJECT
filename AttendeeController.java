package com.examly.demo.Controller;

import com.examly.demo.Model.Attendee;
import com.examly.demo.Service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    // Create Attendee
    @PostMapping
    public ResponseEntity<Attendee> createAttendee(@RequestBody Attendee attendee) {
        return ResponseEntity.ok(attendeeService.saveAttendee(attendee));
    }

    // Get All Attendees with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Attendee>> getAllAttendees(Pageable pageable) {
        return ResponseEntity.ok(attendeeService.getAllAttendees(pageable));
    }

    // Get Attendee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Attendee>> getAttendeeById(@PathVariable Long id) {
        return ResponseEntity.ok(attendeeService.getAttendeeById(id));
    }

    // Find Attendees by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Attendee>> findAttendeesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(attendeeService.findAttendeesByUserId(userId));
    }

    // Find Attendees by Event ID
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Attendee>> findAttendeesByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(attendeeService.findAttendeesByEventId(eventId));
    }

    // Count Attendees for an Event
    @GetMapping("/event/{eventId}/count")
    public ResponseEntity<Long> countAttendeesByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(attendeeService.countAttendeesByEventId(eventId));
    }

    // Update Attendee by ID
    @PutMapping("/{id}")
    public ResponseEntity<Attendee> updateAttendee(@PathVariable Long id, @RequestBody Attendee updatedAttendee) {
        return ResponseEntity.ok(attendeeService.updateAttendee(id, updatedAttendee));
    }

    // Delete Attendee by User and Event
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<Void> deleteAttendeeByUserAndEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        attendeeService.deleteAttendeeByUserAndEvent(userId, eventId);
        return ResponseEntity.noContent().build();
    }
}
