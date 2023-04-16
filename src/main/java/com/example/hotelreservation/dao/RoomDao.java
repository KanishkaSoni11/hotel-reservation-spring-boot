package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Room;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoomDao {

    public List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo, String roomType);
}
