package com.smartcity.controller;

import com.smartcity.model.User;
import com.smartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            User user = userService.loginUser(username, password);
            return ResponseEntity.ok("Login successful for user: " + user.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
