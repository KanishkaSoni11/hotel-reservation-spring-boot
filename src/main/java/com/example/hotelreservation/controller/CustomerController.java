package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.service.CustomerService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(StaffController.class);

	@Autowired
	private CustomerService customerService;

	@PutMapping("/register")
	public int registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer.getFirstName(), "password");
	}

	@GetMapping("/customer/{userEmail}")
	public Customer getCustomerByUserEmail(@PathVariable String userEmail) {
		logger.info("Fetching customer by email");
		return customerService.getCustomerByUserEmail(userEmail);
	}
}
