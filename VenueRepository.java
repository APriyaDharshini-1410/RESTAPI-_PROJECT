package com.examly.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.demo.Model.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    @Modifying
    @Query(value = "INSERT INTO Venue (name, location, capacity) VALUES (?, ?, ?)", nativeQuery = true)
    void saveVenue(String name, String location, int capacity);
    
    @Query("SELECT v FROM Venue v")
    List<Venue> getAllVenues();

    @Query("SELECT v FROM Venue v WHERE v.name = ?1")
    Venue getVenueByName(String name);
}


