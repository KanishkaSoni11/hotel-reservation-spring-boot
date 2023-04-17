package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Customer;
import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationDetails;
import com.example.hotelreservation.model.RoomType;

import java.util.Date;
import com.example.hotelreservation.model.ReservationAssignment;

public interface ReservationDao {

    public Reservation getAllReservation();

    public Integer checkIfReservationIsPossible(Date fromDate, Date toDate, int numberOfRooms, RoomType roomType);

    public ReservationAssignment assignRoom(ReservationAssignment reservationAssignment);

    public int insertIntoReservation(ReservationDetails reservationDetails);

    public Reservation getReservation(Date fromDate, Date toDate, Integer numRooms);

    public int insertIntoReservationPlaced(Reservation reservation, Customer customer);
}
