package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;
import com.example.hotelreservation.model.RoomType;

import java.time.LocalDate;
import com.example.hotelreservation.model.ReservationAssignment;

public interface ReservationDao {

    public Reservation getAllReservation();

    public boolean checkIfReservationIsPossible(LocalDate fromDate, LocalDate toDate, int numberOfRooms, RoomType roomType);

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);

    public Reservation createReservation(ReservationDetails reservationDetails, Customer customer);

    public Reservation getReservationFromCustomerId(int customerId);
}
