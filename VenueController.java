package com.examly.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.demo.Model.Venue;
import com.examly.demo.Service.VenueService;
@RestController
@RequestMapping("/api/venues")
public class VenueController {
@Autowired
private VenueService venueService;
@PostMapping("/Post")
public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
    return ResponseEntity.ok(venueService.createVenue(venue)); 
}
@GetMapping("/Get")
public ResponseEntity<List<Venue>>getAllVenues()
{
    return ResponseEntity.ok(venueService.getAllVenues());
}
@GetMapping("/{id}")
public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
    Optional<Venue> venue = venueService.getVenueById(id);
    return venue.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); 
}
@PutMapping("/{id}")
public ResponseEntity<Venue>updateVenue(@PathVariable Long id,@RequestBody Venue venue)
{
    return venueService.updateVenue(id,venue)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteVenue(@PathVariable Long id)
{
    if(venueService.deleteVenue(id))
    {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}
}
