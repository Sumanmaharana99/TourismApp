package com.tourism.tourism_app.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Booking {
    private int id;
    private String userEmail;
    private String destination;
    private Date travelDate;
    private int numPersons;
    private String specialRequest;
    private Timestamp bookingDate;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Date getTravelDate() { return travelDate; }
    public void setTravelDate(Date travelDate) { this.travelDate = travelDate; }

    public int getNumPersons() { return numPersons; }
    public void setNumPersons(int numPersons) { this.numPersons = numPersons; }

    public String getSpecialRequest() { return specialRequest; }
    public void setSpecialRequest(String specialRequest) { this.specialRequest = specialRequest; }

    public Timestamp getBookingDate() { return bookingDate; }
    public void setBookingDate(Timestamp bookingDate) { this.bookingDate = bookingDate; }
}
