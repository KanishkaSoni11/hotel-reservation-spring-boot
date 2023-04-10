package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.ReservationDao;
import com.example.hotelreservation.dao.StaffRoomDao;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.StaffRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StaffRoom> getAllRooms() {
        return staffRoomDao.getAllRooms();
    }
}
