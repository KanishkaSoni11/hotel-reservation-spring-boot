package com.example.hotelreservation.model;

import java.util.Date;

public class StaffRoom {

    public StaffRoom() {
    }

    private String firstName;

    private Date dateFrom;

    private Date dateTo;

    private String typeOfRoom;

    private int reservationNumber;

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
}
