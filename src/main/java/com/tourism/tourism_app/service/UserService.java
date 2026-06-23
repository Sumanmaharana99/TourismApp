package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.User;
import com.tourism.tourism_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            return "Email already exists!";
        }
        int result = userRepository.save(user);
        return (result > 0) ? "User registered successfully!" : "Error registering user!";
    }

    public boolean loginUser(String email, String password) {
        return userRepository.checkCredentials(email, password);
    }
}
