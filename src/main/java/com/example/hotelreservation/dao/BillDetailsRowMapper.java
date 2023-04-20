package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.BillDetails;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailsRowMapper implements RowMapper<BillDetails> {
	@Override
	public BillDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetails billDetails = new BillDetails();
		billDetails.setBillID(rs.getInt("bill_id"));
		billDetails.setBillDate(rs.getDate("bill_date"));
		billDetails.setPaymentDetails(rs.getString("payment_details"));
		billDetails.setPaymentMethod(rs.getString("payment_method"));
		billDetails.setRoomNumber(rs.getInt("room_number"));
		billDetails.setCost(rs.getInt("cost"));
		billDetails.setBillDescription(rs.getString("bill_description"));
		return billDetails;
	}
}
