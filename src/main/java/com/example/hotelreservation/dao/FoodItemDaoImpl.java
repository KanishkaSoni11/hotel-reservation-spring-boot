package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class FoodItemDaoImpl implements FoodItemDao {

	private static final Logger logger = LogManager.getLogger(FoodItemDaoImpl.class);

	@Autowired
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

	@Override
	public OrderDetails insertIntoOrderDetails(Integer roomNumber) {
		try {
			String sql = "call insert_order_details(?);";
			return jdbcTemplate.queryForObject(sql, new OrderDetailsRowMapper(), roomNumber);
		} catch (Exception e) {
			logger.error("Error while inserting in order_details");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer insertIntoOrderFoodLink(Integer orderId, Integer foodItemId, Integer quantity) {
		try {
			String sql = "insert into order_food_link values (?, ?, ?)";
			return jdbcTemplate.update(sql, orderId, foodItemId, quantity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public OrderDetails callProcedureToUpdateCostAndBill(Integer orderId, Integer roomNumber) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
			Date date = new Date();
			String sql = "call update_order_cost_bill(?, ?, ?)";
			return jdbcTemplate.queryForObject(sql, new OrderDetailsRowMapper(),
					orderId, roomNumber, formatter.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
