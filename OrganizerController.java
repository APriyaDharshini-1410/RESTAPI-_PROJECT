package com.examly.demo.Controller;

import com.examly.demo.Model.Organizer;
import com.examly.demo.Service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    // Create Organizer
    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.saveOrganizer(organizer));
    }

    // Get All Organizers with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Organizer>> getAllOrganizers(Pageable pageable) {
        return ResponseEntity.ok(organizerService.getAllOrganizers(pageable));
    }

    // Get Organizer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Organizer>> getOrganizerById(@PathVariable Long id) {
        return ResponseEntity.ok(organizerService.getOrganizerById(id));
    }

    // Get Organizer by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Organizer>> getOrganizerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(organizerService.getOrganizerByEmail(email));
    }

    // Find Organizers by Name
    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Organizer>> findOrganizersByName(@PathVariable String name) {
        return ResponseEntity.ok(organizerService.findOrganizersByName(name));
    }

    // Count Organizers by Name
    @GetMapping("/count/name/{name}")
    public ResponseEntity<Long> countOrganizersByName(@PathVariable String name) {
        return ResponseEntity.ok(organizerService.countOrganizersByName(name));
    }

    // ✅ Normal Update Organizer (PUT) - Update all fields
    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.updateOrganizer(id, organizer));
    }

    // ✅ Custom Update - Update only Name
    @PutMapping("/update/name/{id}")
    public ResponseEntity<Integer> updateOrganizerName(@PathVariable Long id, @RequestBody String name) {
        return ResponseEntity.ok(organizerService.updateOrganizerName(id, name));
    }

    // ✅ Custom Update - Update only Email
    @PutMapping("/update/email/{id}")
    public ResponseEntity<Integer> updateOrganizerEmail(@PathVariable Long id, @RequestBody String email) {
        return ResponseEntity.ok(organizerService.updateOrganizerEmail(id, email));
    }

    // ✅ Normal Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizerById(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Custom Delete by Email
    @DeleteMapping("/delete/email/{email}")
    public ResponseEntity<Integer> deleteOrganizerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(organizerService.deleteOrganizerByEmail(email));
    }
}
