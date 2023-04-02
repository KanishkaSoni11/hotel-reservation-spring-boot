package com.example.hotelreservation.controller;

import com.example.hotelreservation.model.Staff;
import com.example.hotelreservation.service.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    private static final Logger logger = LogManager.getLogger(StaffController.class);


    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    public List<Staff> getAllStaff(){
        logger.error("Fetching all staff members");
        return staffService.getAllStaff();

    }

    @GetMapping("/staff/{staffId}")
    public Staff getStaffById(@PathVariable int staffId){
        try{
            logger.info("Fetching all staff by id:" + staffId);
            return staffService.getStaffById(staffId);
        }catch(Exception e) {
            logger.error("No staff found");
            return null;
        }
    }


}
