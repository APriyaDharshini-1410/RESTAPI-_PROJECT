package com.examly.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.demo.Model.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    @Modifying
    @Query(value = "INSERT INTO Organizer (name, company_name, experience) VALUES (?, ?, ?)", nativeQuery = true)
    void saveOrganizer(String name, String companyName, int experience);

    @Query("SELECT o FROM Organizer o")
    List<Organizer> getAllOrganizers();

    @Query("SELECT o FROM Organizer o WHERE o.companyName = ?1")
    Organizer getOrganizerByCompanyName(String companyName);
}
