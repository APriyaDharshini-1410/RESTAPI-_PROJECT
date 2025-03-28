package com.examly.demo.Repository;

import com.examly.demo.Model.Speaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    // 📌 **1. Find Speakers by Name**
    @Query("SELECT s FROM Speaker s WHERE s.name = :name")
    List<Speaker> findByName(@Param("name") String name);

    // 📌 **2. Find Speakers by Topic**
    @Query("SELECT s FROM Speaker s WHERE s.topic = :topic")
    List<Speaker> findByTopic(@Param("topic") String topic);

    // 📌 **3. Count Speakers by Topic**
    @Query("SELECT COUNT(s) FROM Speaker s WHERE s.topic = :topic")
    Long countByTopic(@Param("topic") String topic);

    // 📌 **4. Get All Speakers with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<Speaker> findAll(Pageable pageable);
}
