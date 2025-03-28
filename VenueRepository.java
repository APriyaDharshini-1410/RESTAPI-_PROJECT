package com.examly.demo.Repository;

import com.examly.demo.Model.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    // 📌 **1. Find Venues by Location**
    @Query("SELECT v FROM Venue v WHERE v.location = :location")
    List<Venue> findByLocation(@Param("location") String location);

    // 📌 **2. Find Venues with Capacity Greater Than a Value**
    @Query("SELECT v FROM Venue v WHERE v.capacity > :capacity")
    List<Venue> findByCapacityGreaterThan(@Param("capacity") int capacity);

    // 📌 **3. Count Venues in a Specific Location**
    @Query("SELECT COUNT(v) FROM Venue v WHERE v.location = :location")
    Long countByLocation(@Param("location") String location);

    // 📌 **4. Get All Venues with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<Venue> findAll(Pageable pageable);

    // 📌 **5. Update Venue Name by ID**
    @Modifying
    @Transactional
    @Query("UPDATE Venue v SET v.name = :name WHERE v.id = :id")
    int updateVenueName(@Param("id") Long id, @Param("name") String name);

    // 📌 **6. Update Venue Capacity by ID**
    @Modifying
    @Transactional
    @Query("UPDATE Venue v SET v.capacity = :capacity WHERE v.id = :id")
    int updateVenueCapacity(@Param("id") Long id, @Param("capacity") int capacity);

    // 📌 **7. Delete Venue by ID**
    @Modifying
    @Transactional
    @Query("DELETE FROM Venue v WHERE v.id = :id")
    void deleteVenueById(@Param("id") Long id);
}
