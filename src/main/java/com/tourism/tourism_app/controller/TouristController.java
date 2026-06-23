package com.tourism.tourism_app.controller;

import com.tourism.tourism_app.model.Tourist;
import com.tourism.tourism_app.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tourists")
public class TouristController {

    @Autowired
    private TouristService touristService;

    /**
     *  Display all tourists on the homepage
     */
    @GetMapping
    public String viewHomePage(Model model) {
        List<Tourist> tourists = touristService.getAllTourists();
        model.addAttribute("tourists", tourists);
        return "index"; // templates/index.html
    }

    /**
     *  Show form to add a new tourist
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tourist", new Tourist());
        return "add_tourist"; // templates/add_tourist.html
    }

    /**
     *  Save a new tourist
     */
    @PostMapping("/save")
    public String saveTourist(@ModelAttribute("tourist") Tourist tourist) {
        touristService.addTourist(tourist);
        return "redirect:/tourists";
    }

    /**
     *  Show edit form for a tourist
     */
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Tourist tourist = touristService.getTouristById(id);
        model.addAttribute("tourist", tourist);
        return "update_tourist"; // templates/update_tourist.html
    }

    /**
     *  Update an existing tourist
     */
    @PostMapping("/update")
    public String updateTourist(@ModelAttribute("tourist") Tourist tourist) {
        touristService.updateTourist(tourist);
        return "redirect:/tourists";
    }

    /**
     * Delete a tourist by ID
     */
    @GetMapping("/delete/{id}")
    public String deleteTourist(@PathVariable("id") int id) {
        touristService.deleteTourist(id);
        return "redirect:/tourists";
    }
}
