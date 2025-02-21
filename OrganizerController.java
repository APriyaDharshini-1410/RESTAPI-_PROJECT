package com.examly.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.demo.Model.Organizer;
import com.examly.demo.Service.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
@Autowired
private OrganizerService organizerService;
@PostMapping("/Post")
 public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        return ResponseEntity.ok(organizerService.createOrganizer(organizer));
    }
    @GetMapping("/Get")
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }
    @GetMapping("/paginate")
    public ResponseEntity<Page<Organizer>> paginateOrganizers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizerService.paginateOrganizers(page, size));
    } 
    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        if (organizerService.deleteOrganizer(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
