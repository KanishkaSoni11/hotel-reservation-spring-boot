package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.service.ReservationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public Reservation getAllReservation() {
        try {
            logger.info("fetching ");
            return reservationService.getAllReservation();
        } catch (Exception e) {
            logger.error("Invalid credentials");
            return null;
        }
    }
}
