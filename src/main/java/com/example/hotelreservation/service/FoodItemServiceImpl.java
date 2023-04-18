package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.FoodItemDao;
import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.OrderFoodDetails;

import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.PendingFoodOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public OrderDetails placeOrder(OrderFoodDetails orderFoodDetails) {
        OrderDetails orderDetails = foodItemDao.insertIntoOrderDetails(orderFoodDetails.getRoomNumber());
        HashMap<Integer, Integer> orderDetailMap = orderFoodDetails.getOrderDetailsMap();
        for (Map.Entry<Integer, Integer> foodItemQuantity : orderDetailMap.entrySet()) {
            foodItemDao.insertIntoOrderFoodLink(orderDetails.getOrderId(), foodItemQuantity.getKey(), foodItemQuantity.getValue());
        }
        return foodItemDao.callProcedureToUpdateCostAndBill(orderDetails.getOrderId(), orderFoodDetails.getRoomNumber());

    }
}
