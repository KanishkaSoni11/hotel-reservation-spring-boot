package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Customer;

public interface CustomerService {

	public int registerCustomer(String username, String password);

	public Customer getCustomerByUserEmail(String userEmail);
}
