package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;

public interface CustomerDao {

	public Customer loginCustomer(String emailId, String password);

	public Customer registerCustomer(Customer customer);

	public Customer getCustomerByUserEmail(String userEmail);

	public Customer checkoutCustomer(int customerId, int reservationNumber);
}
