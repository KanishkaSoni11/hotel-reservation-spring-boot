package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.ReservationDao;
import com.example.hotelreservation.dao.StaffRoomDao;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.StaffRoom;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    public ReservationDao reservationDao;

    @Autowired
    public StaffRoomDao staffRoomDao;

    @Override
    public Reservation getAllReservation() {
        return reservationDao.getAllReservation();
    }

    @Override
    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType) {
        return reservationDao.checkIfReservationIsPossible(fromDate, toDate, numberOfRooms, roomType);
    }
    public List<StaffRoom> getAllRooms() {
        return staffRoomDao.getAllRooms();
    }

    @Override
    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment) {
        return reservationDao.assignRoom(reservationAssignment);
    }


}
