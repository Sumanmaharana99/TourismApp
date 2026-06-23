package com.tourism.tourism_app.repository;

import com.tourism.tourism_app.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //  Save admin 
    public int save(Admin admin) {
        try {
        	String sql = "INSERT INTO admins (name, email, password) VALUES (?, ?, ?)";

            System.out.println("Executing SQL: " + sql);
            return jdbcTemplate.update(sql,
                    admin.getName(),
                    admin.getEmail(),
                    admin.getPassword());
        } catch (Exception e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


    // Find admin by email
    public Admin findByEmail(String email) {
    	String sql = "SELECT * FROM admins WHERE email = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email},
                    new BeanPropertyRowMapper<>(Admin.class));
        } catch (Exception e) {
            return null;
        }
    }
}
