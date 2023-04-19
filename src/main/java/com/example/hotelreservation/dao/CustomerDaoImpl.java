package com.example.hotelreservation.dao;

import com.example.hotelreservation.controller.CustomerController;
import com.example.hotelreservation.model.Customer;

import com.example.hotelreservation.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer registerCustomer(Customer customer) {
		try {
			String query = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(query,
					customer.getFirstName(), customer.getLastName(),
					customer.getStreet(), customer.getState(), customer.getZipCode(),
					customer.getEmailId(), customer.getContactNumber(),
					customer.getIdentificationNumber(), customer.getPassword());
			return customer;
		} catch(Exception e) {
			logger.error("Exception while registering user");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer loginCustomer(String emailId, String password) {
		try{
			String sql = "select * from customer where email_id = ? and password = ?;";
			return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), emailId, password);
		}catch (Exception e) {
			logger.error("Error while logging in user");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer getCustomerByUserEmail(String userEmail) {
		String query = "SELECT * FROM CUSTOMER WHERE email = ?";
		return jdbcTemplate.queryForObject(query, new CustomerRowMapper(), userEmail);
	}

	@Override
	public Customer checkoutCustomer(int customerId, int reservationNumber) {
		try{
			System.out.println(customerId);
			System.out.println(reservationNumber);
			String query = "call checkout_customer(?,?)";
			jdbcTemplate.queryForObject(query, Integer.class, customerId, reservationNumber);
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}


}
