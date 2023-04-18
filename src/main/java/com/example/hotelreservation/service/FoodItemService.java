package com.example.hotelreservation.service;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.PendingFoodOrders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface FoodItemService {

	public List<FoodItem> getAllFoodItems();

	public List<PendingFoodOrders> getPendingOrders();

	public OrderDetails updateCompletedOrder(int staffId, int orderId);
}
