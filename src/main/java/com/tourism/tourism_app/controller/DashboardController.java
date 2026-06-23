package com.tourism.tourism_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @GetMapping("/user/dashboard")
    public String userDashboard(@RequestParam(value = "email", required = false) String email, Model model) {
        // Optionally pass the user email to dashboard
        model.addAttribute("userEmail", email != null ? email : "Traveler");
        return "user_dashboard"; 
    }
}
