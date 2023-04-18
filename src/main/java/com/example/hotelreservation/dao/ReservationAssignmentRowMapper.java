package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.ReservationAssignment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationAssignmentRowMapper implements RowMapper<ReservationAssignment> {
    @Override
    public ReservationAssignment mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservationAssignment reservationAssignment = new ReservationAssignment();
        reservationAssignment.setReservationNumber(rs.getInt("reservation_number"));
        reservationAssignment.setStaffId(rs.getInt("staff_id"));
        reservationAssignment.setRoomNumber(rs.getInt("room_number"));
        return reservationAssignment;
    }
}
