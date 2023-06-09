package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Reservation;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.Room;
import com.example.hotelreservation.model.StaffRoom;
import com.example.hotelreservation.service.ReservationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/roomsunassigned")
    public List<StaffRoom> getAllRooms() {
        try {
            logger.info("fetching ");
            List<StaffRoom> resList = reservationService.getAllRooms();

            List<StaffRoom> finalList = new ArrayList<>();
            for (int i = 0; i < resList.size(); i++) {
                if (resList.get(i).getNumberOfRooms() > 1) {
                    for (int j = 0; j < resList.get(i).getNumberOfRooms(); j++) {
                        StaffRoom staffRoom = new StaffRoom(resList.get(i).getFirstName(),
                                resList.get(i).getDate_from(), resList.get(i).getDateTo(), resList.get(i).getTypeOfRoom(),
                                resList.get(i).getReservationNumber(), j+1);
                        finalList.add(staffRoom);
                    }

                } else if(resList.get(i).getNumberOfRooms() == 1) {
                    finalList.add(resList.get(i));
                }
            }

            return finalList;
        } catch (Exception e) {
            logger.error("Invalid credentials");
            return null;
        }
    }

    @GetMapping("/room/{reservationId}")
    public List<Room> getRoomFromReservationId(@PathVariable int reservationId) {
        return reservationService.getRoomFromReservationId(reservationId);
    }

    @GetMapping("/{customerId}")
    public Reservation getReservationFromCustomerId(@PathVariable int customerId) {
        try {
            logger.info("fetching ");
            return reservationService.getReservationFromCustomerId(customerId);
        } catch (Exception e) {
            logger.error("Invalid credentials");
            return null;
        }
    }

//    @GetMapping("/room/{reservationId}")
//    public List<Room> getRoomFromReservationId(@PathVariable int reservationId) {
//        return reservationService.getRoomFromReservationId(reservationId);
//    }
//
//    @GetMapping("/{customerId}")
//    public Reservation getReservationFromCustomerId(@PathVariable String customerId) {
//        try {
//            logger.info("fetching ");
//            return reservationService.getReservationFromCustomerId(customerId);
//        } catch (Exception e) {
//            logger.error("Invalid credentials");
//            return null;
//        }
//    }

    @PostMapping("/assignroom")
    public ReservationAssignment assignRoom(@RequestBody ReservationAssignment reservationAssignment) {
        try {
            System.out.println(reservationAssignment.getReservationNumber());
            System.out.println(reservationAssignment.getRoomNumber());
            System.out.println(reservationAssignment.getStaffId());
            logger.info(reservationAssignment.toString());
            return reservationService.assignRoom(reservationAssignment);

        } catch (Exception e) {
            logger.error("Error");
            return null;
        }

    }
}
