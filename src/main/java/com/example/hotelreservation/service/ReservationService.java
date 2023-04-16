package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.RoomType;

import java.util.Date;

public interface ReservationService {
    public Reservation getAllReservation();

    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType);
}

