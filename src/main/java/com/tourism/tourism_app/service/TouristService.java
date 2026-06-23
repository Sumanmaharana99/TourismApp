package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.Tourist;
import com.tourism.tourism_app.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    // Add a new tourist
    public void addTourist(Tourist tourist) {
        touristRepository.save(tourist);
    }

    // Get all tourists
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    // Get tourist by ID
    public Tourist getTouristById(int id) {
        return touristRepository.findById(id);
    }

    // Update tourist
    public void updateTourist(Tourist tourist) {
        touristRepository.update(tourist);
    }

    // Delete tourist
    public void deleteTourist(int id) {
        touristRepository.deleteById(id);
    }
}
