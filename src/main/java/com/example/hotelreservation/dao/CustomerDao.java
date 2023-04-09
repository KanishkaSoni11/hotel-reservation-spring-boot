package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;

public interface CustomerDao {

	public Customer registerCustomer(Customer customer);

	public Customer getCustomerByUserEmail(String userEmail);
}
