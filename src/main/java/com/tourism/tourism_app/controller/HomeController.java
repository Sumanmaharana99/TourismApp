package com.tourism.tourism_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Load portal page for both "/" and "/portal" URLs
    @GetMapping({"/", "/portal"})
    public String showPortal() {
        return "portal"; // refers to templates/portal.html
    }
}
