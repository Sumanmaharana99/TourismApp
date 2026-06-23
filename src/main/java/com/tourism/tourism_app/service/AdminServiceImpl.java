package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.Admin;
import com.tourism.tourism_app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void registerAdmin(Admin admin) {
        // Optional: Prevent duplicate registration
        Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin == null) {
            adminRepository.save(admin);
        } else {
            throw new RuntimeException("Admin with this email already exists!");
        }
    }

    @Override
    public Admin login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
