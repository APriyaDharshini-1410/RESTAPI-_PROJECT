package com.examly.demo.Service;

import com.examly.demo.Model.Attendee;
import com.examly.demo.Repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {
    
    @Autowired
    private AttendeeRepository attendeeRepository;

    // Create Attendee
    public Attendee saveAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    // Get All Attendees with Pagination & Sorting
    public Page<Attendee> getAllAttendees(Pageable pageable) {
        return attendeeRepository.findAll(pageable);
    }

    // Get Attendee by ID
    public Optional<Attendee> getAttendeeById(Long id) {
        return attendeeRepository.findById(id);
    }

    // Find Attendees by User ID
    public List<Attendee> findAttendeesByUserId(Long userId) {
        return attendeeRepository.findByUserId(userId);
    }

    // Find Attendees by Event ID
    public List<Attendee> findAttendeesByEventId(Long eventId) {
        return attendeeRepository.findByEventId(eventId);
    }

    // Count Attendees for an Event
    public Long countAttendeesByEventId(Long eventId) {
        return attendeeRepository.countAttendeesByEventId(eventId);
    }

    // Update Attendee by ID
    @Transactional
    public Attendee updateAttendee(Long id, Attendee updatedAttendee) {
        Attendee existingAttendee = attendeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendee not found"));

        existingAttendee.setUserId(updatedAttendee.getUserId());
        existingAttendee.setEventId(updatedAttendee.getEventId());
        existingAttendee.setRegistrationDate(updatedAttendee.getRegistrationDate());

        return attendeeRepository.save(existingAttendee);
    }

    // Delete Attendee by User and Event
    @Transactional
    public void deleteAttendeeByUserAndEvent(Long userId, Long eventId) {
        attendeeRepository.deleteByUserAndEvent(userId, eventId);
    }
}
