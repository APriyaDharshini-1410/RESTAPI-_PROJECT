package com.examly.demo.Controller;

import com.examly.demo.Model.Venue;
import com.examly.demo.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    // Create Venue
    @PostMapping
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        return ResponseEntity.ok(venueService.saveVenue(venue));
    }

    // Get All Venues with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<Venue>> getAllVenues(Pageable pageable) {
        return ResponseEntity.ok(venueService.getAllVenues(pageable));
    }

    // Get Venue by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Venue>> getVenueById(@PathVariable Long id) {
        return ResponseEntity.ok(venueService.getVenueById(id));
    }

    // Find Venues by Location
    @GetMapping("/search/location/{location}")
    public ResponseEntity<List<Venue>> findVenuesByLocation(@PathVariable String location) {
        return ResponseEntity.ok(venueService.findVenuesByLocation(location));
    }

    // Find Venues with Capacity Greater Than
    @GetMapping("/search/capacity/{capacity}")
    public ResponseEntity<List<Venue>> findVenuesByCapacity(@PathVariable int capacity) {
        return ResponseEntity.ok(venueService.findVenuesByCapacity(capacity));
    }

    // Count Venues in a Location
    @GetMapping("/count/location/{location}")
    public ResponseEntity<Long> countVenuesByLocation(@PathVariable String location) {
        return ResponseEntity.ok(venueService.countVenuesByLocation(location));
    }

    // Update Venue Name
    @PutMapping("/update/name/{id}")
    public ResponseEntity<Integer> updateVenueName(@PathVariable Long id, @RequestBody String name) {
        return ResponseEntity.ok(venueService.updateVenueName(id, name));
    }

    // Update Venue Capacity
    @PutMapping("/update/capacity/{id}")
    public ResponseEntity<Integer> updateVenueCapacity(@PathVariable Long id, @RequestBody int capacity) {
        return ResponseEntity.ok(venueService.updateVenueCapacity(id, capacity));
    }

    // Delete Venue by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVenueById(@PathVariable Long id) {
        venueService.deleteVenueById(id);
        return ResponseEntity.noContent().build();
    }
}
