package com.tourism.tourism_app.controller;

import com.tourism.tourism_app.model.User;
import com.tourism.tourism_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Show login page
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // Handle login form
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        boolean success = userService.loginUser(user.getEmail(), user.getPassword());
        if (success) {
            model.addAttribute("userEmail", user.getEmail());
            return "user_dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials!");
            return "login";
        }
    }

    // Show signup form
    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // Handle signup form
    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user, Model model) {
        String message = userService.registerUser(user);
        if (message.contains("successfully")) {
            model.addAttribute("success", message);
            return "login";
        } else {
            model.addAttribute("error", message);
            return "signup";
        }
    }
}
