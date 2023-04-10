package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<Reservation> {
	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation reservation = new Reservation();
		reservation.setReservationNumber(rs.getInt("reservation_number"));
		reservation.setNumberOfRooms(rs.getInt("number_of_rooms"));
		reservation.setNumberOfGuests(rs.getInt("number_of_guests"));
		reservation.setTypeOfRoom(DaoUtils.getRoomTypeFromString(rs.getString("type_of_room")));
		reservation.setDateOfReservation(rs.getDate("date_of_reservation"));
		reservation.setFromDate(rs.getDate("date_from"));
		reservation.setToDate(rs.getDate("date_to"));
		return reservation;

	}
}
