package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Override
    public List<Room> getRoomFromReservationId(int reservationId) {
        try {
            String sql = "select r.* from room r "
                    + "join reservation_assignment ra "
                    + "on r.room_number = ra.room_number "
                    + "where ra.reservation_number = ?";
            return jdbcTemplate.query(sql, new RoomRowMapper(), reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
