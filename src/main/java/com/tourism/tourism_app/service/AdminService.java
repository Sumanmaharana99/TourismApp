package com.tourism.tourism_app.service;

import com.tourism.tourism_app.model.Admin;

public interface AdminService {
    void registerAdmin(Admin admin);
    Admin login(String email, String password);
}
