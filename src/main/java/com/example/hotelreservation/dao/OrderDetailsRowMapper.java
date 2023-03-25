package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.OrderDetails;

import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRowMapper implements RowMapper<OrderDetails> {
	@Override
	public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(rs.getInt("order_id"));
		orderDetails.setCost(rs.getInt("cost"));
		orderDetails.setRoomNumber(rs.getInt("room_number"));
		orderDetails.setStaffResponsible(rs.getInt("staff_id"));
		return orderDetails;
	}
}
