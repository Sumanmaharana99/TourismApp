package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.Booking;
import com.tourism.tourism_app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String createBooking(Booking booking) {
        booking.setBookingDate(new Timestamp(System.currentTimeMillis()));
        bookingRepository.save(booking);
        return "Booking saved successfully!";
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }

    
    @Override
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByUserEmail(email);
    }
}
