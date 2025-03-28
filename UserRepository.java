package com.examly.demo.Repository;

import com.examly.demo.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 📌 **1. Find Users by Role**
    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") String role);

    // 📌 **2. Find User by Email**
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    // 📌 **3. Count Users by Role**
    @Query("SELECT COUNT(u) FROM User u WHERE u.role = :role")
    Long countByRole(@Param("role") String role);

    // 📌 **4. Get All Users with Pagination & Sorting**
    @SuppressWarnings("null")
    Page<User> findAll(Pageable pageable);

    // 📌 **5. Insert User using JPQL**
    @Modifying
    @Transactional
    @Query("INSERT INTO User (name, email, password, role) VALUES (:name, :email, :password, :role)")
    void insertUser(@Param("name") String name, @Param("email") String email, @Param("password") String password, @Param("role") String role);

    // 📌 **6. Update User Name by ID**
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    int updateUserName(@Param("id") Long id, @Param("name") String name);

    // 📌 **7. Update User Password by ID**
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
    int updateUserPassword(@Param("id") Long id, @Param("password") String password);

    // 📌 **8. Delete User by ID**
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteUserById(@Param("id") Long id);

    // 📌 **9. Delete User by Email**
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteUserByEmail(@Param("email") String email);
}
