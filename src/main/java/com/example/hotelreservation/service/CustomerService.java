package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Customer;

import java.util.List;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);

	public Customer getCustomerByUserEmail(String userEmail);
}
