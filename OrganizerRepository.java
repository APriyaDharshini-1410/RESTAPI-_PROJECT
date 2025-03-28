package com.examly.demo.Repository;

import com.examly.demo.Model.Organizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    // Find by Email
    @Query("SELECT o FROM Organizer o WHERE o.email = ?1")
    Optional<Organizer> findByEmail(String email);

    // Find by Name
    @Query("SELECT o FROM Organizer o WHERE LOWER(o.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Organizer> findByNameContainingIgnoreCase(String name);

    // Update Name
    @Modifying
    @Transactional
    @Query("UPDATE Organizer o SET o.name = ?2 WHERE o.id = ?1")
    int updateOrganizerName(Long id, String name);

    // Update Email
    @Modifying
    @Transactional
    @Query("UPDATE Organizer o SET o.email = ?2 WHERE o.id = ?1")
    int updateOrganizerEmail(Long id, String email);

    // Delete by Email
    @Modifying
    @Transactional
    @Query("DELETE FROM Organizer o WHERE o.email = ?1")
    int deleteByEmail(String email);

    // Count by Name
    @Query("SELECT COUNT(o) FROM Organizer o WHERE LOWER(o.name) = LOWER(?1)")
    Long countByName(String name);

    // Pagination and Sorting
    @SuppressWarnings("null")
    Page<Organizer> findAll(Pageable pageable);
}
