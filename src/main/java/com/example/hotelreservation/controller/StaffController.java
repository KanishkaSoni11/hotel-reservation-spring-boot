package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.ActiveReservationDetails;
import com.example.hotelreservation.model.Staff;
import com.example.hotelreservation.service.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    private static final Logger logger = LogManager.getLogger(StaffController.class);


    @Autowired
    private StaffService staffService;

//    @GetMapping("/staff")
//    public List<Staff> getAllStaff(){
//        logger.error("Fetching all staff members");
//        return staffService.getAllStaff();
//
//    }

    @GetMapping("/staff/{staffId}")
    public Staff getStaffById(@PathVariable int staffId) {
        try {
            logger.info("Fetching all staff by id:" + staffId);
            return staffService.getStaffById(staffId);
        } catch (Exception e) {
            logger.error("No staff found");
            return null;
        }
    }

    @PostMapping("/staff/login")
    public Staff loginStaff(@RequestBody Staff staff) {
        try {
            logger.info("Checking login cred for " + staff.getStaffId() + " " + staff.getPassword());
            return staffService.loginStaff(staff.getStaffId(), staff.getPassword());
        } catch (Exception e) {
            logger.error("Invalid credentials");
            return null;
        }
    }

    @GetMapping("/activeReservation")
    public List<ActiveReservationDetails> getActiveReservations() {
        try{
            logger.info("Fetching active reservations");
            return staffService.activeReservations();
        }catch (Exception e) {
            logger.error("Could not fetch");
            return null;
        }
    }


}
