package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.ActiveReservationDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActiveReservationRowMapper implements RowMapper<ActiveReservationDetails> {
    @Override
    public ActiveReservationDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        ActiveReservationDetails activeReservationDetails = new ActiveReservationDetails();
        activeReservationDetails.setFirstName(rs.getString("first_name"));
        activeReservationDetails.setDateFrom(rs.getDate("date_from"));
        activeReservationDetails.setDateTo(rs.getDate("date_to"));
        activeReservationDetails.setTypeOfRoom(rs.getString("type_of_room"));
        activeReservationDetails.setReservationNumber(rs.getInt("reservation_number"));
        activeReservationDetails.setRoomNumber(rs.getInt("room_number"));
        activeReservationDetails.setCustomerId(rs.getInt("customer_id"));
        return activeReservationDetails;
    }
}
