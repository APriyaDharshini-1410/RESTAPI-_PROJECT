package com.examly.demo.Service;

import com.examly.demo.Model.Organizer;
import com.examly.demo.Repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    // Create Organizer
    public Organizer saveOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    // Get All Organizers with Pagination & Sorting
    public Page<Organizer> getAllOrganizers(Pageable pageable) {
        return organizerRepository.findAll(pageable);
    }

    // Get Organizer by ID
    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    // Get Organizer by Email
    public Optional<Organizer> getOrganizerByEmail(String email) {
        return organizerRepository.findByEmail(email);
    }

    // Find Organizers by Name
    public List<Organizer> findOrganizersByName(String name) {
        return organizerRepository.findByNameContainingIgnoreCase(name);
    }

    // Count Organizers by Name
    public Long countOrganizersByName(String name) {
        return organizerRepository.countByName(name);
    }

    // ✅ Normal Update Organizer (PUT) - Update all fields
    public Organizer updateOrganizer(Long id, Organizer organizer) {
        Optional<Organizer> existingOrganizer = organizerRepository.findById(id);
        if (existingOrganizer.isPresent()) {
            Organizer updatedOrganizer = existingOrganizer.get();
            updatedOrganizer.setName(organizer.getName());
            updatedOrganizer.setEmail(organizer.getEmail());
            updatedOrganizer.setPhoneNumber(organizer.getPhoneNumber());
            return organizerRepository.save(updatedOrganizer);
        }
        return null;
    }

    // ✅ Custom Update - Update only Name
    @Transactional
    public int updateOrganizerName(Long id, String name) {
        return organizerRepository.updateOrganizerName(id, name);
    }

    // ✅ Custom Update - Update only Email
    @Transactional
    public int updateOrganizerEmail(Long id, String email) {
        return organizerRepository.updateOrganizerEmail(id, email);
    }

    // ✅ Normal Delete by ID
    public void deleteOrganizerById(Long id) {
        organizerRepository.deleteById(id);
    }

    // ✅ Custom Delete by Email
    @Transactional
    public int deleteOrganizerByEmail(String email) {
        return organizerRepository.deleteByEmail(email);
    }
}
