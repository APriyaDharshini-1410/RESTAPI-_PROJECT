package com.examly.demo.Service;

import com.examly.demo.Model.Venue;
import com.examly.demo.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    // Create Venue
    public Venue saveVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Get All Venues with Pagination & Sorting
    public Page<Venue> getAllVenues(Pageable pageable) {
        return venueRepository.findAll(pageable);
    }

    // Get Venue by ID
    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    // Find Venues by Location
    public List<Venue> findVenuesByLocation(String location) {
        return venueRepository.findByLocation(location);
    }

    // Find Venues with Capacity Greater Than
    public List<Venue> findVenuesByCapacity(int capacity) {
        return venueRepository.findByCapacityGreaterThan(capacity);
    }

    // Count Venues in a Location
    public Long countVenuesByLocation(String location) {
        return venueRepository.countByLocation(location);
    }

    // Update Venue Name
    @Transactional
    public int updateVenueName(Long id, String name) {
        return venueRepository.updateVenueName(id, name);
    }

    // Update Venue Capacity
    @Transactional
    public int updateVenueCapacity(Long id, int capacity) {
        return venueRepository.updateVenueCapacity(id, capacity);
    }

    // Delete Venue by ID
    @Transactional
    public void deleteVenueById(Long id) {
        venueRepository.deleteVenueById(id);
    }
}
