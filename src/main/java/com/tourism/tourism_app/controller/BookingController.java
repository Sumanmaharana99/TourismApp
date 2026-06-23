package com.tourism.tourism_app.controller;

import com.tourism.tourism_app.model.Booking;
import com.tourism.tourism_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    
    @GetMapping("/new")
    public String showBookingForm(@RequestParam("destination") String destination,
                                  @RequestParam("email") String email,
                                  Model model) {
        Booking booking = new Booking();
        booking.setDestination(destination);
        booking.setUserEmail(email);

        model.addAttribute("booking", booking);
        return "booking_form"; 
    }

    /**
     * Save booking details and show success page.
     */
    @GetMapping("/success")
    public String bookingSuccess(Model model) {
        model.addAttribute("message", "Your booking was successful!");
        return "booking_success";
    }
    @PostMapping("/save")
    public String saveBooking(@ModelAttribute Booking booking, Model model) {
        // Call service to save the booking
        bookingService.createBooking(booking);

        // Add confirmation message
        model.addAttribute("message", "Your booking for " + booking.getDestination() + " is confirmed!");

        // Redirect to success page
        return "booking_success";  
    }
    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam("id") int id,
                                @RequestParam("email") String email,
                                Model model) {
    	bookingService.deleteBookingById(id);

        model.addAttribute("bookings", bookingService.getBookingsByEmail(email));
        model.addAttribute("userEmail", email);
        model.addAttribute("message", "Booking cancelled successfully!");
        return "booking_list";
    }



    
    @GetMapping("/user")
    public String viewUserBookings(@RequestParam("email") String email, Model model) {
        model.addAttribute("bookings", bookingService.getBookingsByEmail(email));
        model.addAttribute("userEmail", email);
        return "booking_list"; 
    }
}
