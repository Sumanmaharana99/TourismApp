package com.tourism.tourism_app.repository;

import com.tourism.tourism_app.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save booking
    public int save(Booking booking) {
        String sql = "INSERT INTO bookings (user_email, destination, travel_date, num_persons, special_request, booking_date) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                booking.getUserEmail(),
                booking.getDestination(),
                booking.getTravelDate(),
                booking.getNumPersons(),
                booking.getSpecialRequest(),
                booking.getBookingDate());
    }

    // Get all bookings
    public List<Booking> findAll() {
        String sql = "SELECT * FROM bookings ORDER BY booking_date DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Booking.class));
    }

    //  Get bookings by user email
    public List<Booking> findByUserEmail(String email) {
        String sql = "SELECT * FROM bookings WHERE user_email = ? ORDER BY booking_date DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Booking.class), email);
    }

    //  Delete booking by ID
    public void deleteById(int id) {
        String sql = "DELETE FROM bookings WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
