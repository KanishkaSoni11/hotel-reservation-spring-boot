package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.PendingFoodOrders;

import java.util.List;

public interface FoodItemDao {

	public List<FoodItem> getAllFoodItems();

	public List<PendingFoodOrders> getPendingOrders();

	public OrderDetails updateCompletedOrder(int staffId, int orderId);

}
