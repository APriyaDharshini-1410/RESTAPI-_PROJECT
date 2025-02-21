package com.examly.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.demo.Model.Venue;
import com.examly.demo.Repository.VenueRepository;

@Service
public class VenueService {
@Autowired
private VenueRepository venueRepository;

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Optional<Venue> updateVenue(Long id, Venue venueDetails) {
        return venueRepository.findById(id).map(venue -> {
            venue.setName(venueDetails.getName());
            venue.setLocation(venueDetails.getLocation());
            return venueRepository.save(venue);
        });
    }

    public boolean deleteVenue(Long id) {
        return venueRepository.findById(id).map(venue -> {
            venueRepository.delete(venue);
            return true;
        }).orElse(false);
    }
}
