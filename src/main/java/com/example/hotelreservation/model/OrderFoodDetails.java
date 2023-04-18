package com.example.hotelreservation.model;

import java.util.HashMap;
import java.util.Map;

public class OrderFoodDetails {

	private Customer customer;
	private Reservation reservation;
	private Integer roomNumber;
	private HashMap<Integer, Integer> orderDetailsMap;

	public OrderFoodDetails() {
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public HashMap<Integer, Integer> getOrderDetailsMap() {
		return orderDetailsMap;
	}

	public void setOrderDetailsMap(HashMap<Integer, Integer> orderDetailsMap) {
		this.orderDetailsMap = orderDetailsMap;
	}
}
