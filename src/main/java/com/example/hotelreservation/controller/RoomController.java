package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Room;
import com.example.hotelreservation.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private RoomService roomService;

    @GetMapping("/available/{dateFrom}/{dateTo}/{roomType}")
    public List<Room> getAvailableRooms(@PathVariable("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom,
                                        @PathVariable("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo,
                                        @PathVariable String roomType) {
        try {
            logger.info("Fetching ");
            return roomService.getAvailableRooms(dateFrom, dateTo, roomType);
        } catch (Exception e) {
            logger.error("Invalid ");
            return null;
        }
    }

}

