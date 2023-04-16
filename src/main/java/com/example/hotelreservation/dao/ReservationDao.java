package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationAssignment;

public interface ReservationDao {

    public Reservation getAllReservation();

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);
}
