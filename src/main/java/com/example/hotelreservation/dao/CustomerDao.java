package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;

public interface CustomerDao {

	public int registerCustomer(String username, String password);

	public Customer getCustomerByUserEmail(String userEmail);
}
