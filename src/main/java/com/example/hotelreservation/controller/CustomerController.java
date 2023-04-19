package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;
import com.example.hotelreservation.service.CustomerService;
import com.example.hotelreservation.service.ReservationService;
import com.example.hotelreservation.service.RoomService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/customers")
    public String getALlCustomers() {
        logger.error("Fetching all authors");
        return "customerService.getAllAuthors();";
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        logger.info(customer);
        customer.setIdentificationNumber(UUID.randomUUID().toString());
        return customerService.registerCustomer(customer);
    }


    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody Customer customer) {
        logger.info("Logging the customer in");
        return customerService.loginCustomer(customer);
    }

    @PostMapping("/reserve")
    public Reservation makeReservation(@RequestBody ReservationDetails reservationDetails) {
        logger.info("Checking if the reservation can be made or not");
        return reservationService.makeReservation(reservationDetails);
    }

    @PostMapping("/checkout/{customerId}/{reservationNumber}")
    public Customer checkout(@PathVariable int customerId, @PathVariable int reservationNumber) {
        logger.info("Checking out customer");
        return customerService.checkoutCustomer(customerId, reservationNumber);
    }
}
