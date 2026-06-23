package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.Booking;
import java.util.List;

public interface BookingService {

    //  Create booking
    String createBooking(Booking booking);

    //  Get all bookings (for admin)
    List<Booking> getAllBookings();

    //  Delete booking
    void deleteBookingById(int id);

    //  Get all bookings by user email
    List<Booking> getBookingsByEmail(String email);
}
