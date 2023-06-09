package com.example.hotelreservation.dao;


import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;
import com.example.hotelreservation.model.RoomType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.hotelreservation.model.ReservationAssignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Repository
public class ReservationDaoImpl implements ReservationDao{

    private static final Logger logger = LogManager.getLogger(ReservationDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public ReservationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reservation getAllReservation() {
        String sql = "select * from reservation" ;
        return jdbcTemplate.queryForObject(sql, new ReservationRowMapper());
    }

    @Override
    public boolean checkIfReservationIsPossible(LocalDate fromDate, LocalDate toDate, int numberOfRooms, RoomType roomType) {
        try {
            String sql = "select isReservationPossible(?, ?, ? , ?)";
            Integer out = jdbcTemplate.queryForObject(sql, Integer.class,
                    new Object[]{fromDate, toDate, numberOfRooms, roomType.getString()});
            return out == 1;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to check for reservation");
            return false;
        }
    }

    @Override
    public Reservation createReservation(ReservationDetails reservationDetails, Customer customer) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
            Date date = new Date();
            String sql = "call create_reservation(?, ?, ?, ?, ?, ?, ?)";
            return jdbcTemplate.queryForObject(sql, new ReservationRowMapper(),
                    reservationDetails.getFromDate(),
                    reservationDetails.getToDate(),
                    reservationDetails.getNumRooms(),
                    reservationDetails.getNumGuests(),
                    formatter.format(date),
                    reservationDetails.getRoomType().getString(),
                    customer.getCustomerID());
        } catch (Exception e) {
            logger.error("Error while creating reservation");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment) {
        try{
            String sql = "call staff_check_in(?, ?, ? ,?)";

            jdbcTemplate.queryForObject(sql, new ReservationAssignmentRowMapper(),
                    reservationAssignment.getReservationNumber(),
                    reservationAssignment.getStaffId(),
                    reservationAssignment.getRoomNumber(),
                    "Checked-in"
            );

            return reservationAssignment;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Reservation getReservationFromCustomerId(int customerId) {
        try {
            String sql = "select r.* from reservation r "
                    + "join reservation_placed rp "
                    + "on r.reservation_number = rp.reservation_id "
                    + "where rp.customer_id = ?";
            return jdbcTemplate.queryForObject(sql, new ReservationRowMapper(), customerId);
        } catch (Exception e) {
            logger.error("Error while fetching reservation from customerid");
            e.printStackTrace();
            return null;
        }
    }

}
