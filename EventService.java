package com.examly.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.demo.Model.Event;
import com.examly.demo.Repository.EventRepository;

@Service
public class EventService {
@Autowired
private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Page<Event> getAllEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventRepository.findAll(pageable);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Optional<Event> updateEvent(Long id, Event eventDetails) {
        return eventRepository.findById(id).map(event -> {
            event.setName(eventDetails.getName());
            event.setDateTime(eventDetails.getDateTime());
           //vent.setVenue(eventDetails.getVenue());
            return eventRepository.save(event);
        });
    }

    public boolean deleteEvent(Long id) {
        return eventRepository.findById(id).map(event -> {
            eventRepository.delete(event);
            return true;
        }).orElse(false);
    }
}
