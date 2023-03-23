package com.example.hotelreservation.model;

public class OrderDetails {

	public OrderDetails() {

	}

	private int orderId;
	private int cost;

	// TODO: maybe convert these to objects of Room and Staff?
	private int roomNumber;
	private int staffResponsible;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getStaffResponsible() {
		return staffResponsible;
	}

	public void setStaffResponsible(int staffResponsible) {
		this.staffResponsible = staffResponsible;
	}
}
