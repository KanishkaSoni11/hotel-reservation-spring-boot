package com.example.hotelreservation.model;

import java.util.Date;

public class StaffRoom {

    public StaffRoom() {
    }

    private String firstName;

    private Date dateFrom;

    private Date dateTo;

    private String typeOfRoom;

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

    public void setDate_from(Date date_from) {
        this.dateFrom = date_from;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }
}
