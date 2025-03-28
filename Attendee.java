package com.examly.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "attendees")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long eventId;

    public Attendee() {}

    public Attendee(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Object getRegistrationDate() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getRegistrationDate'");
    }

    public void setRegistrationDate(Object registrationDate) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setRegistrationDate'");
    }
}
