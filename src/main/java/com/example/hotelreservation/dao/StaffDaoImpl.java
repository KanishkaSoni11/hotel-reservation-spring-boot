package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Staff;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl implements StaffDao {

    private final JdbcTemplate jdbcTemplate;

    public StaffDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Staff getStaffById(int staffId) {
        String sql = "select * from staff where staff_id = ?;";
        return jdbcTemplate.queryForObject(sql, new StaffRowMapper(), staffId);
    }

    @Override
    public List<Staff> getAllStaff() {
        String sql = "select * from staff;";
        return jdbcTemplate.query(sql, new StaffRowMapper());
    }
}
