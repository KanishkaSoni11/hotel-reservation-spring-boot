package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Staff;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRowMapper implements RowMapper<Staff> {
	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();

		staff.setStaffId(rs.getInt("staff_id"));
		staff.setFirstName(rs.getString("first_name"));
		staff.setLastName(rs.getString("last_name"));
		staff.setStreet(rs.getString("street"));
		staff.setState(rs.getString("state"));
		staff.setZipCode(rs.getInt("zip_code"));
		staff.setEmailId(rs.getString("email_id"));
		staff.setContactNumber(rs.getInt("contact_number"));
		staff.setSalary(rs.getInt("salary"));
		staff.setJoiningDate(rs.getDate("joining_date"));

		return staff;
	}
}
