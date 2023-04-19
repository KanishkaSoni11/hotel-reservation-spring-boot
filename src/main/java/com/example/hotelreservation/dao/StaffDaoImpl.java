package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.ActiveReservationDetails;
import com.example.hotelreservation.model.ReservationAssignment;
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

    @Override
    public Staff loginStaff(int staffId, String password) {
        String sql = "select * from staff where staff_id = ? and password = ?;";
        return jdbcTemplate.queryForObject(sql, new StaffRowMapper(), staffId, password);
    }

    @Override
    public List<ActiveReservationDetails> activeReservations() {
        try{
            String sql = "call active_reservation_proc();";
            System.out.println(jdbcTemplate.query(sql, new ActiveReservationRowMapper()));
            return jdbcTemplate.query(sql, new ActiveReservationRowMapper());
        }catch (Exception e){
            System.out.println("here ");
            e.printStackTrace();
            return null;
        }

    }
}
