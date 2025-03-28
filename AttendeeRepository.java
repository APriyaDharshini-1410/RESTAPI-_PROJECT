package com.examly.demo.Repository;

import com.examly.demo.Model.Attendee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    // 📌 **1. Find Attendees by User ID**
    @Query("SELECT a FROM Attendee a WHERE a.userId = :userId")
    List<Attendee> findByUserId(@Param("userId") Long userId);

    // 📌 **2. Find Attendees by Event ID**
    @Query("SELECT a FROM Attendee a WHERE a.eventId = :eventId")
    List<Attendee> findByEventId(@Param("eventId") Long eventId);

    // 📌 **3. Count Attendees for an Event**
    @Query("SELECT COUNT(a) FROM Attendee a WHERE a.eventId = :eventId")
    Long countAttendeesByEventId(@Param("eventId") Long eventId);

    // 📌 **4. Get All Attendees with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<Attendee> findAll(Pageable pageable);

    // 📌 **5. Delete Attendee by User and Event**
    @Modifying
    @Transactional
    @Query("DELETE FROM Attendee a WHERE a.userId = :userId AND a.eventId = :eventId")
    void deleteByUserAndEvent(@Param("userId") Long userId, @Param("eventId") Long eventId);
}
