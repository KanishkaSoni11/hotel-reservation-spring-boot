package com.example.hotelreservation.controller;

import com.example.hotelreservation.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    private OrderService orderService;


}
