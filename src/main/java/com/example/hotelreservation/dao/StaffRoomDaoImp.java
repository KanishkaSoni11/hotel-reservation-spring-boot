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
        try {
            String sql = "call staff_room_proc();";
            System.out.println(sql);
            System.out.println(jdbcTemplate.query(sql, new StaffRoomRowMapper()));
            return jdbcTemplate.query(sql, new StaffRoomRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
