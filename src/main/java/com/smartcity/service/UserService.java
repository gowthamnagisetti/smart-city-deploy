package com.smartcity.service;

import com.smartcity.model.User;
import com.smartcity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        // Store password as plain text (not recommended for production)
        return userRepository.save(user);
    }

    
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPassword().equals(password)) { // Compare plain text password
            return user;
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}
