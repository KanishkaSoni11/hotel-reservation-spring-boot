package com.example.hotelreservation.model;

public class ReservationPlaced {

	public ReservationPlaced() {

	}

	private int customerId;
	private int reservationId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
}
