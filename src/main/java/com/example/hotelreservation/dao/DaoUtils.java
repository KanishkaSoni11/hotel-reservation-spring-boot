package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.RoomType;

public class DaoUtils {

	public static RoomType getRoomTypeFromString(String roomType) {
		switch (roomType) {
			case "KING":
				return RoomType.KING;
			case "DELUXE":
				return RoomType.DELUXE;
			case "SUITE":
				return RoomType.SUITE;
		}
		return null;
	}

	public static boolean convertIntToBoolean(int num) {
		return !(num == 0);
	}
}
