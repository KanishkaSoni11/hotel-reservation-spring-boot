package com.example.hotelreservation.model;

public enum RoomType {

	STANDARD("STANDARD"),
	DELUXE("DELUXE"),
	SUITE("SUITE");

	private String roomType;

	RoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomType() {
		return roomType;
	}
}
