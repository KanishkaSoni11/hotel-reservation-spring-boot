package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.CustomerDao;
import com.example.hotelreservation.model.Customer;

import com.example.hotelreservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerDao.registerCustomer(customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		return customerDao.loginCustomer(customer.getEmailId(), customer.getPassword());
	}

	@Override
	public Customer getCustomerByUserEmail(String userEmail) {
		return customerDao.getCustomerByUserEmail(userEmail);
	}

	@Override
	public Customer checkoutCustomer(int customerId, int roomNumber) {
		return customerDao.checkoutCustomer(customerId, roomNumber);
	}
}
