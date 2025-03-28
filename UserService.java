package com.examly.demo.Service;

import com.examly.demo.Model.User;
import com.examly.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get All Users with Pagination & Sorting
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // Get User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Find Users by Role
    public List<User> findUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Find User by Email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Count Users by Role
    public Long countUsersByRole(String role) {
        return userRepository.countByRole(role);
    }

    // Update User Name
    @Transactional
    public int updateUserName(Long id, String name) {
        return userRepository.updateUserName(id, name);
    }

    // Update User Password
    @Transactional
    public int updateUserPassword(Long id, String password) {
        return userRepository.updateUserPassword(id, password);
    }

    // Delete User by ID
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

    // Delete User by Email
    @Transactional
    public void deleteUserByEmail(String email) {
        userRepository.deleteUserByEmail(email);
    }
}
