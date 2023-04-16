package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.StaffRoom;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRoomDaoImp implements StaffRoomDao{

    private final JdbcTemplate jdbcTemplate;

    public StaffRoomDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StaffRoom> getAllRooms() {
        String sql = "call staff_room_proc();";
        return jdbcTemplate.query(sql, new StaffRoomRowMapper());
    }
}
