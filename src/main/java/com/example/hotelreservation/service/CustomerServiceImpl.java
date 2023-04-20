package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.CustomerDao;
import com.example.hotelreservation.model.BillDetails;
import com.example.hotelreservation.model.Customer;

import com.example.hotelreservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public List<BillDetails> getBillDetails(int roomNumber) {
		return customerDao.getBillDetails(roomNumber);
	}

	@Override
	public Integer getTotalAmount(int roomNumber) {
		return customerDao.getTotalAmount(roomNumber);
	}

	@Override
	public Customer updateBillPaid(int roomNumber, int customerId) {
		return customerDao.updateBillPaid(roomNumber, customerId);
	}
}
