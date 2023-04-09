package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerID(rs.getString("customer_id"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setStreet(rs.getString("street"));
		customer.setState(rs.getString("state"));
		customer.setZipCode(rs.getInt("zipcode"));
		customer.setContactNumber(rs.getInt("contact_no"));
		customer.setEmailId(rs.getString("email_id"));
		customer.setIdentificationNumber(rs.getString("identification_number"));
		customer.setPassword(rs.getString("password"));
		return customer;
	}
}
