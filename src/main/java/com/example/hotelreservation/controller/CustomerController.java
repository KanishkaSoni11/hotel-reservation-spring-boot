package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.service.CustomerService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public String getALlCustomers() {
		logger.error("Fetching all authors");
		return "customerService.getAllAuthors();";
	}

	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		logger.info(customer);
		customer.setCustomerID(UUID.randomUUID().toString());
		customer.setIdentificationNumber(UUID.randomUUID().toString());
		return customerService.registerCustomer(customer);
	}

	@GetMapping("/{userEmail}")
	public Customer getCustomerByUserEmail(@PathVariable String userEmail) {
		logger.info("Fetching customer by email");
		return customerService.getCustomerByUserEmail(userEmail);
	}
}
