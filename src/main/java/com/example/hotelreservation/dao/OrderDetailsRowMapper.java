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
		orderDetails.setCost(rs.getInt("total_cost"));
		orderDetails.setRoomNumber(rs.getInt("room_number"));
		orderDetails.setOrderStatus(rs.getString("order_status"));
		return orderDetails;
	}
}
