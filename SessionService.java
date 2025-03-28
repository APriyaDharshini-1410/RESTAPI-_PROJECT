package com.examly.demo.Service;

import com.examly.demo.Model.Session;
import com.examly.demo.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    // Create Session
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    // Get All Sessions with Pagination & Sorting
    public Page<Session> getAllSessions(Pageable pageable) {
        return sessionRepository.findAll(pageable);
    }

    // Get Session by ID
    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    // Update Session (PUT Implementation)
    public Session updateSession(Long id, Session sessionDetails) {
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));

        existingSession.setTitle(sessionDetails.getTitle());
        existingSession.setStartTime(sessionDetails.getStartTime());
        existingSession.setEndTime(sessionDetails.getEndTime());
        existingSession.setEventId(sessionDetails.getEventId());
        existingSession.setSpeakerId(sessionDetails.getSpeakerId());

        return sessionRepository.save(existingSession);
    }

    // Find Sessions by Event ID
    public List<Session> findByEventId(Long eventId) {
        return sessionRepository.findByEventId(eventId);
    }

    // Find Sessions by Speaker ID
    public List<Session> findBySpeakerId(Long speakerId) {
        return sessionRepository.findBySpeakerId(speakerId);
    }

    // Find Sessions by Time Range
    public List<Session> findByTimeRange(String startTime, String endTime) {
        return sessionRepository.findByTimeRange(startTime, endTime);
    }

    // Count Sessions for an Event
    public Long countByEventId(Long eventId) {
        return sessionRepository.countByEventId(eventId);
    }

    // Delete Session
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
