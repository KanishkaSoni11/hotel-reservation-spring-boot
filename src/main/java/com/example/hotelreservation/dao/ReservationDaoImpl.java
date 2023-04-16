package com.example.hotelreservation.dao;


import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.hotelreservation.model.ReservationAssignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
