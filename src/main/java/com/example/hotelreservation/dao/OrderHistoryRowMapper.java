package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.OrderHistoryItem;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderHistoryRowMapper implements RowMapper<OrderHistoryItem> {
	@Override
	public OrderHistoryItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderHistoryItem orderHistoryItem = new OrderHistoryItem();
		orderHistoryItem.setOrderId(rs.getInt("order_id"));
		orderHistoryItem.setItemName(rs.getString("item_name"));
		orderHistoryItem.setRoomNumber(rs.getInt("room_number"));
		orderHistoryItem.setStatus(rs.getString("order_status"));
		orderHistoryItem.setQuantity(rs.getInt("quantity"));
		return orderHistoryItem;
	}
}
