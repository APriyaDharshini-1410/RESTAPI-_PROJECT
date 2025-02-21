package com.examly.demo.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
   // private Venue venue;
public Event()
{

}
public Event(String name,String description,LocalDateTime dateTime,String location)
{
    this.name = name;
    this.description = description;
    this.dateTime = dateTime;
    this.location = location; 
    
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public LocalDateTime getDateTime() {
    return dateTime;
}
public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
}
public String getLocation() {
    return location;
}
public void setLocation(String location) {
    this.location = location;
}
// public Venue getVenue() {
//     return venue;
// }
// public void setVenue(Venue venue) {
//     this.venue = venue;
// }

    
}