package com.examly.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.demo.Model.Organizer;
import com.examly.demo.Repository.OrganizerRepository;

@Service
public class OrganizerService {
@Autowired
 private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Page<Organizer> paginateOrganizers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return organizerRepository.findAll(pageable);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public boolean deleteOrganizer(Long id) {
        return organizerRepository.findById(id).map(organizer -> {
            organizerRepository.delete(organizer);
            return true;
        }).orElse(false);
    }
}
