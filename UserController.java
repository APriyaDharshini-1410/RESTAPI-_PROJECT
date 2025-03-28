package com.examly.demo.Controller;

import com.examly.demo.Model.User;
import com.examly.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // Get All Users with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Find Users by Role
    @GetMapping("/search/role/{role}")
    public ResponseEntity<List<User>> findUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.findUsersByRole(role));
    }

    // Find User by Email
    @GetMapping("/search/email/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    // Count Users by Role
    @GetMapping("/count/role/{role}")
    public ResponseEntity<Long> countUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.countUsersByRole(role));
    }

    // Update User Name
    @PutMapping("/update/name/{id}")
    public ResponseEntity<Integer> updateUserName(@PathVariable Long id, @RequestBody String name) {
        return ResponseEntity.ok(userService.updateUserName(id, name));
    }

    // Update User Password
    @PutMapping("/update/password/{id}")
    public ResponseEntity<Integer> updateUserPassword(@PathVariable Long id, @RequestBody String password) {
        return ResponseEntity.ok(userService.updateUserPassword(id, password));
    }

    // Delete User by ID
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete User by Email
    @DeleteMapping("/delete/email/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
