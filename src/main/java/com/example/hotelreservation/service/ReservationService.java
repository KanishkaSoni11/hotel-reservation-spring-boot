package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.Room;
import com.example.hotelreservation.model.StaffRoom;

import java.util.List;

public interface ReservationService {
    public Reservation getAllReservation();

    public Reservation makeReservation(ReservationDetails reservationDetails);

    public List<StaffRoom> getAllRooms();

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);

    public Reservation getReservationFromCustomerId(int customerId);

    public List<Room> getRoomFromReservationId(int reservationId);
}

