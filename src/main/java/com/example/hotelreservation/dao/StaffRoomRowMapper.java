package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.StaffRoom;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRoomRowMapper implements RowMapper<StaffRoom> {

    @Override
    public StaffRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
        StaffRoom staffRoom = new StaffRoom();
        staffRoom.setFirstName(rs.getString("first_name"));
        staffRoom.setDate_from(rs.getDate("date_from"));
        staffRoom.setDateTo(rs.getDate("date_to"));
        staffRoom.setTypeOfRoom(rs.getString("type_of_room"));
        staffRoom.setReservationNumber(rs.getInt("reservation_number"));
        staffRoom.setNumberOfRooms(rs.getInt("number_of_rooms"));
        return staffRoom;
    }
}
