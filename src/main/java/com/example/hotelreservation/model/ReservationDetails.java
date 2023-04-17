package com.example.hotelreservation.model;

import java.util.Date;

public class ReservationDetails {

	private Customer currentCustomer;
	private Date fromDate;
	private Date toDate;
	private Integer numGuests;
	private Integer numRooms;
	private RoomType roomType;

	public ReservationDetails() {
		// Mandatory empty constructor
	}

	public Integer getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(Integer numGuests) {
		this.numGuests = numGuests;
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

	public Integer getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(Integer numRooms) {
		this.numRooms = numRooms;
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
