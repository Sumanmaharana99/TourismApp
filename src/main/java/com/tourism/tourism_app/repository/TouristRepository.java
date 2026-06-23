package com.tourism.tourism_app.repository;

import com.tourism.tourism_app.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TouristRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create (Insert)
    public int save(Tourist tourist) {
        String sql = "INSERT INTO tourists (name, city, package_type, budget) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, tourist.getName(), tourist.getCity(), tourist.getPackageType(), tourist.getBudget());
    }

    // Read (Get all)
    public List<Tourist> findAll() {
        String sql = "SELECT * FROM tourists";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tourist.class));
    }

    // Read (Get by ID)
    public Tourist findById(int id) {
        String sql = "SELECT * FROM tourists WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Tourist.class), id);
    }

    // Update
    public int update(Tourist tourist) {
        String sql = "UPDATE tourists SET name = ?, city = ?, package_type = ?, budget = ? WHERE id = ?";
        return jdbcTemplate.update(sql, tourist.getName(), tourist.getCity(), tourist.getPackageType(), tourist.getBudget(), tourist.getId());
    }

    // Delete
    public int deleteById(int id) {
        String sql = "DELETE FROM tourists WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
