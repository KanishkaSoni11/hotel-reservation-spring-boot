package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    private final JdbcTemplate jdbcTemplate;

    public RoomDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo, String roomType) {
        return jdbcTemplate.query
                ("call get_available_rooms_staff(?, ?, ?);",
                        new Object[] { roomType, dateFrom.toString() ,dateTo.toString()},
                        new RoomRowMapper());
    }
}
