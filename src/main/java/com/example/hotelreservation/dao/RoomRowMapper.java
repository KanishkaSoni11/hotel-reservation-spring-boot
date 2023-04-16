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
		room.setRoomType(rs.getString("room_type"));
		room.setAvailabilityStatus((rs.getString("availability_status")));
		room.setCost(rs.getInt("cost"));
		return room;
	}
}
