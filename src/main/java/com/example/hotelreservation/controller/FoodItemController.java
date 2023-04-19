package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.OrderHistoryItem;
import com.example.hotelreservation.model.PendingFoodOrders;

import com.example.hotelreservation.model.OrderFoodDetails;
import com.example.hotelreservation.service.FoodItemService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    private static final Logger logger = LogManager.getLogger(FoodItemController.class);

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/")
    public List<FoodItem> getAllFoodItems() {
        logger.info("Fetching all available food items");
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/pendingOrders")
    public  List<PendingFoodOrders> getPendingOrders() {
        logger.info("Fetching available food items");
        List<PendingFoodOrders> pendingFoodOrders =  foodItemService.getPendingOrders();
        Map<Integer, List<PendingFoodOrders>> res = new HashMap<>();
        for(int i = 0; i < pendingFoodOrders.size(); i++){
            if(!res.containsKey(pendingFoodOrders.get(i).getRoomNumber())){
                res.put(pendingFoodOrders.get(i).getRoomNumber(),new ArrayList<>());
            }
            res.get(pendingFoodOrders.get(i).getRoomNumber()).add(pendingFoodOrders.get(i));
        }
        return pendingFoodOrders;
    }

    @PostMapping("/updateCompletedOrders/{staffId}/{orderId}")
    public OrderDetails updateCompletedOrders(@PathVariable int staffId, @PathVariable int orderId) {
        logger.info("Fetching available food items");
        return foodItemService.updateCompletedOrder(staffId, orderId);
    }

    @PostMapping("/placeOrder")
    public OrderDetails placeOrder(@RequestBody OrderFoodDetails orderFoodDetails) {
        logger.info("Placing food order");
        return foodItemService.placeOrder(orderFoodDetails);
    }

    @GetMapping("/orderHistory/{customerId}")
    public List<OrderHistoryItem> getOrderHistoryFromCustomerId(@PathVariable Integer customerId) {
        logger.info("Getting order history for the customer {}",customerId);
        return foodItemService.getOrderHistoryFromCustomerId(customerId);
    }
}

