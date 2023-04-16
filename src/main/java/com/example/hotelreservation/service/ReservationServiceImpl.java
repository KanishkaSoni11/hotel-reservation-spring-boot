package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.ReservationDao;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    public ReservationDao reservationDao;

    @Override
    public Reservation getAllReservation() {
        return reservationDao.getAllReservation();
    }

    @Override
    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType) {
        return reservationDao.checkIfReservationIsPossible(fromDate, toDate, numberOfRooms, roomType);
    }
}
