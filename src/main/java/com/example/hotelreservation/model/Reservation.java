package com.example.hotelreservation.model;

import java.util.Date;

public class Reservation {

	public Reservation() {
	}

	private int reservationNumber;
	private int numberOfRooms;
	private int numberOfGuests;
	private RoomType typeOfRoom;
	private Date dateOfReservation;
	private Date fromDate;
	private Date toDate;

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public RoomType getTypeOfRoom() {
		return typeOfRoom;
	}

	public void setTypeOfRoom(RoomType typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}

	public Date getDateOfReservation() {
		return dateOfReservation;
	}

	public void setDateOfReservation(Date dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
