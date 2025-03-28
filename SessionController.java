package com.examly.demo.Controller;

import com.examly.demo.Model.Session;
import com.examly.demo.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // Create Session
    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.saveSession(session));
    }

    // Get All Sessions with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Session>> getAllSessions(Pageable pageable) {
        return ResponseEntity.ok(sessionService.getAllSessions(pageable));
    }

    // Get Session by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Session>> getSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getSessionById(id));
    }

    // Find Sessions by Event ID
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Session>> findByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(sessionService.findByEventId(eventId));
    }

    // Find Sessions by Speaker ID
    @GetMapping("/speaker/{speakerId}")
    public ResponseEntity<List<Session>> findBySpeakerId(@PathVariable Long speakerId) {
        return ResponseEntity.ok(sessionService.findBySpeakerId(speakerId));
    }

    // Find Sessions by Time Range
    @GetMapping("/time-range")
    public ResponseEntity<List<Session>> findByTimeRange(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseEntity.ok(sessionService.findByTimeRange(startTime, endTime));
    }

    // Count Sessions for an Event
    @GetMapping("/event/{eventId}/count")
    public ResponseEntity<Long> countByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(sessionService.countByEventId(eventId));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable Long id, @RequestBody Session sessionDetails) {
        Session updatedSession = sessionService.updateSession(id, sessionDetails);
        return ResponseEntity.ok(updatedSession);
    }
    
    // Delete Session by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
