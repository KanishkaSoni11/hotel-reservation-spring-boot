package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.FoodItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodItemDaoImpl implements FoodItemDao {

	private static final Logger logger = LogManager.getLogger(FoodItemDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<FoodItem> getAllFoodItems() {
		try {
			String sql = "select * from food_item where item_available = 1";
			return jdbcTemplate.query(sql, new FoodItemRowMapper());
		} catch(Exception e) {
			logger.error("Error while fetching list of food items");
			e.printStackTrace();
			return null;
		}
	}
}
