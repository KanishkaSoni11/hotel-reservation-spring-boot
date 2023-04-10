package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl implements ReservationDao{
    private final JdbcTemplate jdbcTemplate;

    public ReservationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reservation getAllReservation() {
        String sql = "select * from reservation" ;
        return jdbcTemplate.queryForObject(sql, new ReservationRowMapper());
    }
}
