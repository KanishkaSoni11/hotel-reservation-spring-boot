package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.FoodItemDao;
import com.example.hotelreservation.model.FoodItem;

import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.PendingFoodOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	private FoodItemDao foodItemDao;

	@Override
	public List<FoodItem> getAllFoodItems() {
		return foodItemDao.getAllFoodItems();
	}

	@Override
	public List<PendingFoodOrders> getPendingOrders() {
		return foodItemDao.getPendingOrders();
	}

	@Override
	public OrderDetails updateCompletedOrder(int staffId, int orderId) {
		return foodItemDao.updateCompletedOrder(staffId, orderId);
	}
}
