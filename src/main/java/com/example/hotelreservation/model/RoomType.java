package com.example.hotelreservation.model;

public enum RoomType {

	STANDARD("STANDARD"),
	DELUXE("DELUXE"),
	SUITE("SUITE");

	private final String roomType;

	RoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getString() {
		return this.roomType;
	}
}
