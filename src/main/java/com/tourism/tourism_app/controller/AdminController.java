package com.tourism.tourism_app.controller;

import com.tourism.tourism_app.model.Admin;
import com.tourism.tourism_app.service.AdminService;
import com.tourism.tourism_app.service.TouristService;
import com.tourism.tourism_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TouristService touristService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/login")
    public String loginPage() {
        return "admin_login";
    }

    

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Admin admin = adminService.login(email, password);
        if (admin != null) {
            model.addAttribute("admin", admin);
            model.addAttribute("places", touristService.getAllTourists());
            model.addAttribute("bookings", bookingService.getAllBookings());

            return "admin_dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials!");
            return "admin_login";
        }
    }
    
 // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("places", touristService.getAllTourists());
        model.addAttribute("bookings", bookingService.getAllBookings());

        return "admin_dashboard";
    }

    // Show Add Tourist Place Form
    @GetMapping("/places/add")
    public String showAddPlaceForm(Model model) {
        model.addAttribute("tourist", new com.tourism.tourism_app.model.Tourist());
        return "add_place";
    }

    // Handle Add Tourist Place
    @PostMapping("/places/add")
    public String addPlace(@ModelAttribute("tourist") com.tourism.tourism_app.model.Tourist tourist) {
        touristService.addTourist(tourist);
        return "redirect:/admin/dashboard";
    }

    // Delete Tourist Place
    @GetMapping("/places/delete/{id}")
    public String deletePlace(@PathVariable int id) {
        touristService.deleteTourist(id);
        return "redirect:/admin/dashboard";
    }

    // Show Update Form
    @GetMapping("/places/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("tourist", touristService.getTouristById(id));
        return "edit_place";
    }

    // Handle Update
    @PostMapping("/places/update")
    public String updatePlace(@ModelAttribute("tourist") com.tourism.tourism_app.model.Tourist tourist) {
        touristService.updateTourist(tourist);
        return "redirect:/admin/dashboard";
    }
    
    
    
    
    @GetMapping("/bookings/delete/{id}")
    public String deleteBooking(@PathVariable int id) {
        bookingService.deleteBookingById(id);
        return "redirect:/admin/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/admin/login";
    }


}
