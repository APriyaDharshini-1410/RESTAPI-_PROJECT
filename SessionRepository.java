package com.examly.demo.Repository;

import com.examly.demo.Model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    // 📌 **1. Find Sessions by Event ID**
    @Query("SELECT s FROM Session s WHERE s.eventId = :eventId")
    List<Session> findByEventId(@Param("eventId") Long eventId);

    // 📌 **2. Find Sessions by Speaker ID**
    @Query("SELECT s FROM Session s WHERE s.speakerId = :speakerId")
    List<Session> findBySpeakerId(@Param("speakerId") Long speakerId);

    // 📌 **3. Find Sessions between two time periods**
    @Query("SELECT s FROM Session s WHERE s.startTime >= :startTime AND s.endTime <= :endTime")
    List<Session> findByTimeRange(@Param("startTime") String startTime, @Param("endTime") String endTime);

    // 📌 **4. Count Sessions for an Event**
    @Query("SELECT COUNT(s) FROM Session s WHERE s.eventId = :eventId")
    Long countByEventId(@Param("eventId") Long eventId);

    // 📌 **5. Get All Sessions with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<Session> findAll(Pageable pageable);
}
