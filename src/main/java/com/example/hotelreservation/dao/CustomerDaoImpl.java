package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int registerCustomer(String username, String password) {
		String query = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(query,
				12345, username, "Bhagat", "Boylston Street",
				"MA", 02215, "rajat@mail.com", 9999, "12345");
	}

	@Override
	public Customer getCustomerByUserEmail(String userEmail) {
		String query = "SELECT * FROM CUSTOMER WHERE email = ?";
		return jdbcTemplate.queryForObject(query, new CustomerRowMapper(), userEmail);
	}


}
