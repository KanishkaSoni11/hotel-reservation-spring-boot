package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;

import java.util.List;

public interface FoodItemDao {

	public List<FoodItem> getAllFoodItems();

	public OrderDetails insertIntoOrderDetails(Integer roomNumber);

	public Integer insertIntoOrderFoodLink(Integer orderId, Integer foodItemId, Integer quantity);

	public OrderDetails callProcedureToUpdateCostAndBill(Integer orderId, Integer roomNumber);

}
