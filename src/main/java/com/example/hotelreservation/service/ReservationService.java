package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;
import java.util.Date;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.StaffRoom;

import java.util.List;

public interface ReservationService {
    public Reservation getAllReservation();


    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType);

    public List<StaffRoom> getAllRooms();

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);
}

