package com.examly.demo.Repository;

import com.examly.demo.Model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // 📌 **1. Find Events by Location**
    @Query("SELECT e FROM Event e WHERE e.location = :location")
    List<Event> findByLocation(@Param("location") String location);

    // 📌 **2. Find Events after a Certain Date**
    @Query("SELECT e FROM Event e WHERE e.dateTime >= :dateTime")
    List<Event> findUpcomingEvents(@Param("dateTime") LocalDateTime dateTime);

    // 📌 **3. Count Events at a Location**
    @Query("SELECT COUNT(e) FROM Event e WHERE e.location = :location")
    Long countByLocation(@Param("location") String location);

    // 📌 **4. Get All Events with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<Event> findAll(Pageable pageable);

    // 📌 **5. Update Event Name by ID**
    @Modifying
    @Transactional
    @Query("UPDATE Event e SET e.name = :name WHERE e.id = :id")
    int updateEventName(@Param("id") Long id, @Param("name") String name);

    // 📌 **6. Update Event Location by ID**
    @Modifying
    @Transactional
    @Query("UPDATE Event e SET e.location = :location WHERE e.id = :id")
    int updateEventLocation(@Param("id") Long id, @Param("location") String location);

    // 📌 **7. Delete Event by ID**
    @Modifying
    @Transactional
    @Query("DELETE FROM Event e WHERE e.id = :id")
    void deleteEventById(@Param("id") Long id);
}
