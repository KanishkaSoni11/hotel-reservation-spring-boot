package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.FoodItem;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodItemRowMapper implements RowMapper<FoodItem> {
	@Override
	public FoodItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		FoodItem foodItem = new FoodItem();
		foodItem.setItemId(rs.getInt("item_id"));
		foodItem.setItemName(rs.getString("item_name"));
		foodItem.setItemDescription(rs.getString("item_desc"));
		foodItem.setItemAvailable(rs.getInt("item_available"));
		foodItem.setCost(rs.getInt("cost"));
		return foodItem;
	}
}
