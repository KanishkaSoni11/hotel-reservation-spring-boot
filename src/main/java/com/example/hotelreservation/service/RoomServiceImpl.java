package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.RoomDaoImpl;
import com.example.hotelreservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDaoImpl roomDao;
    @Override
    public List<Room> getAvailableRooms(LocalDate dateFrom, LocalDate dateTo, String roomType) {
        System.out.println("In service");
        return roomDao.getAvailableRooms( dateFrom,  dateTo,  roomType);
    }
}
