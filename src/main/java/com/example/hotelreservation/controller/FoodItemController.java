package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.FoodItem;
import com.example.hotelreservation.model.OrderDetails;
import com.example.hotelreservation.model.OrderFoodDetails;
import com.example.hotelreservation.service.FoodItemService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/food/")
public class FoodItemController {

    private static final Logger logger = LogManager.getLogger(FoodItemController.class);

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/")
    public List<FoodItem> getAllFoodItems() {
        logger.info("Fetching all available food items");
        return foodItemService.getAllFoodItems();
    }

    @PostMapping("/placeOrder")
    public OrderDetails placeOrder(@RequestBody OrderFoodDetails orderFoodDetails) {
        logger.info("Placing food order");
        return foodItemService.placeOrder(orderFoodDetails);
    }
}

