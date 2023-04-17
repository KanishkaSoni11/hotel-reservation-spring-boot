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
    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType) {
        try {
            String sql = "select isReservationPossible(?, ?, ? , ?)";
            return jdbcTemplate.queryForObject(sql, Integer.class,
                    new Object[]{fromDate, toDate, numberOfRooms, roomType.getString()});
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to check for reservation");
            return 0;
        }
    }

    @Override
    public int insertIntoReservation(ReservationDetails reservationDetails) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            Date date = new Date();
            String query = "insert into reservation values (?, ?, ?, ?, ?, ?, ?)";
            return jdbcTemplate.update(query,
                    reservationDetails.getNumRooms(),
                    reservationDetails.getNumGuests(),
                    reservationDetails.getRoomType().getString(),
                    formatter.format(date),
                    reservationDetails.getFromDate(),
                    reservationDetails.getToDate());
        } catch(Exception e) {
            logger.error("Error while inserting into Reservation");
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Reservation getReservation(Date fromDate, Date toDate, Integer numRooms) {
        try {
            String sql = "select * from reservation where date_from = ? and date_to = ? and number_of_rooms = ?";
            return jdbcTemplate.queryForObject(sql, new ReservationRowMapper(), fromDate, toDate, numRooms);
        } catch(Exception e) {
            logger.error("Error while fetching the reservation");
            return null;
        }
    }

    @Override
    public int insertIntoReservationPlaced(Reservation reservation, Customer customer) {
        try {
            String sql = "insert into reservation_placed values (?, ?)";
            return jdbcTemplate.update(sql, customer.getCustomerID(), reservation.getReservationNumber());
        } catch(Exception e) {
            logger.error("Error while inserting into reservation_placed");
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment) {
        String sql = "insert into reservation_assignment values (?, ?, ?, ?);";

         jdbcTemplate.update(sql,
                 reservationAssignment.getReservationNumber(),
                 reservationAssignment.getStaffId(),
                 reservationAssignment.getRoomNumber(),
                 "Checked-in"
                 );

         return reservationAssignment;
    }
}
