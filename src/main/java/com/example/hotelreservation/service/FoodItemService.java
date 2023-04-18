package com.example.hotelreservation.service;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.OrderFoodDetails;

import java.util.List;

public interface FoodItemService {

	public List<FoodItem> getAllFoodItems();

	public OrderDetails placeOrder(OrderFoodDetails orderFoodDetails);
}
