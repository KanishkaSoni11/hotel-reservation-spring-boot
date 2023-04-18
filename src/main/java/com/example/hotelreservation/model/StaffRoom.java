package com.example.hotelreservation.model;

import java.util.Date;

public class StaffRoom {

    public StaffRoom() {
    }

    public StaffRoom(String firstName, Date dateFrom, Date dateTo, String typeOfRoom, int reservationNumber, int numberOfRooms) {
        this.firstName = firstName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.typeOfRoom = typeOfRoom;
        this.reservationNumber = reservationNumber;
        this.numberOfRooms = numberOfRooms;
    }

    private String firstName;

    private Date dateFrom;

    private Date dateTo;

    private String typeOfRoom;

    private int reservationNumber;

    private int numberOfRooms;
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getDate_from() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDate_from(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
