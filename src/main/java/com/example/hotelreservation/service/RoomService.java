package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo, String roomType);
}
