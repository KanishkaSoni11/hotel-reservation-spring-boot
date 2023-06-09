package com.example.hotelreservation.service;

import com.example.hotelreservation.model.BillDetails;
import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;

import java.util.List;

public interface CustomerService {

	public Customer loginCustomer(Customer customer);

	public Customer registerCustomer(Customer customer);

	public Customer getCustomerByUserEmail(String userEmail);

	public Customer checkoutCustomer(int customerId, int roomNumber);

	public List<BillDetails> getBillDetails(int roomNumber);

	public Integer getTotalAmount (int roomNumber);

	public Customer updateBillPaid(int roomNumber, int customerId);
}
