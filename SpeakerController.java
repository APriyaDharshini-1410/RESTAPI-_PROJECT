package com.examly.demo.Controller;

import com.examly.demo.Model.Speaker;
import com.examly.demo.Service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    // Create Speaker
    @PostMapping
    public ResponseEntity<Speaker> createSpeaker(@RequestBody Speaker speaker) {
        return ResponseEntity.ok(speakerService.saveSpeaker(speaker));
    }

    // Get All Speakers with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Speaker>> getAllSpeakers(Pageable pageable) {
        return ResponseEntity.ok(speakerService.getAllSpeakers(pageable));
    }

    // Get Speaker by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Speaker>> getSpeakerById(@PathVariable Long id) {
        return ResponseEntity.ok(speakerService.getSpeakerById(id));
    }

    // Find Speakers by Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Speaker>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(speakerService.findByName(name));
    }

    // Find Speakers by Topic
    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Speaker>> findByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(speakerService.findByTopic(topic));
    }

    // Count Speakers by Topic
    @GetMapping("/topic/{topic}/count")
    public ResponseEntity<Long> countByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(speakerService.countByTopic(topic));
    }

    // Update Speaker by ID
    @PutMapping("/{id}")
    public ResponseEntity<Speaker> updateSpeaker(@PathVariable Long id, @RequestBody Speaker updatedSpeaker) {
        return ResponseEntity.ok(speakerService.updateSpeaker(id, updatedSpeaker));
    }

    // Delete Speaker by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeaker(@PathVariable Long id) {
        speakerService.deleteSpeaker(id);
        return ResponseEntity.noContent().build();
    }
}
