package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Room;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {
	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room = new Room();
		room.setRoomNumber(rs.getInt("room_number"));
		room.setRoomType(DaoUtils.getRoomTypeFromString(rs.getString("room_type")));
		room.setAvailabilityStatus(DaoUtils.convertIntToBoolean(rs.getInt("availability_status")));
		room.setCost(rs.getInt("cost"));
		return room;
	}
}
