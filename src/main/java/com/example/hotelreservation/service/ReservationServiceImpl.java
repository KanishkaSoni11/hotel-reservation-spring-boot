package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.ReservationDao;
import com.example.hotelreservation.dao.RoomDao;
import com.example.hotelreservation.dao.StaffRoomDao;
import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.Room;
import com.example.hotelreservation.model.StaffRoom;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    public ReservationDao reservationDao;

    @Autowired
    public StaffRoomDao staffRoomDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public Reservation getAllReservation() {
        return reservationDao.getAllReservation();
    }

    @Override
    public Reservation makeReservation(ReservationDetails reservationDetails) {
        logger.info("Starting making reservation");
        Integer isReservationPossible = reservationDao.checkIfReservationIsPossible(
                reservationDetails.getFromDate(),
                reservationDetails.getToDate(),
                reservationDetails.getNumRooms(),
                reservationDetails.getRoomType());
        if (isReservationPossible > 0) {
            logger.info("Reservation is possible. Procedding with the reservation");
            return reservationDao.createReservation(reservationDetails, reservationDetails.getCurrentCustomer());
        } else {
            logger.info("Reservation is not possible. Please choose different dates");
            return null;
        }
    }
    public List<StaffRoom> getAllRooms() {
        return staffRoomDao.getAllRooms();
    }

    @Override
    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment) {
        return reservationDao.assignRoom(reservationAssignment);
    }

    @Override
    public Reservation getReservationFromCustomerId(String customerId) {
        return reservationDao.getReservationFromCustomerId(customerId);
    }

    @Override
    public List<Room> getRoomFromReservationId(int reservationId) {
        return roomDao.getRoomFromReservationId(reservationId);
    }
}
