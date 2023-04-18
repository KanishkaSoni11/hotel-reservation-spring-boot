package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.PendingFoodOrders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PendingFoodOrderRowMapper implements RowMapper<PendingFoodOrders> {
    @Override
    public PendingFoodOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
        PendingFoodOrders pendingFoodOrders = new PendingFoodOrders();
        pendingFoodOrders.setRoomNumber(rs.getInt("room_number"));
        pendingFoodOrders.setFoodItem(rs.getString("item_name"));
        pendingFoodOrders.setQuantity(rs.getInt("quantity"));
        pendingFoodOrders.setOrderId(rs.getInt("order_id"));
        return pendingFoodOrders;
    }
}
