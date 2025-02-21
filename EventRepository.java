package com.examly.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.examly.demo.Model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    
}
