package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Customer;

import java.util.List;

public interface CustomerService {

	public Customer loginCustomer(Customer customer);

	public Customer registerCustomer(Customer customer);

	public Customer getCustomerByUserEmail(String userEmail);
}
