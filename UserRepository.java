package com.examly.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.examly.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
