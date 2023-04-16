package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.StaffRoom;

import java.util.List;

public interface ReservationService {
    public Reservation getAllReservation();

    public List<StaffRoom> getAllRooms();

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);
}

