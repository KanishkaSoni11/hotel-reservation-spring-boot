package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.BillDetails;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/healthCheck")
    public String checkHealth() {
        logger.info("Health check");
        return "Health check successful";
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

    @PostMapping("/checkout/{customerId}/{roomNumber}")
    public Customer checkout(@PathVariable int customerId, @PathVariable int roomNumber) {
        logger.info("Checking out customer");
        return customerService.checkoutCustomer(customerId, roomNumber);
    }

    @GetMapping("/getBillDetails/{roomNumber}")
    public List<BillDetails> getBillDetails(@PathVariable int roomNumber){
        try{
            return customerService.getBillDetails(roomNumber);

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    @GetMapping("/totalAmount/{roomNumber}")
    public Integer getTotalAmount(@PathVariable int roomNumber)  {
        return customerService.getTotalAmount(roomNumber);

    }

    @GetMapping("/billPaid/{roomNumber}/{customerId}")
    public Customer updateBillPaid(@PathVariable int roomNumber, @PathVariable int customerId){
        return customerService.updateBillPaid(roomNumber,customerId);

    }
}
