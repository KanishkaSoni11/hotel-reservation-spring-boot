package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.ActiveReservationDetails;
import com.example.hotelreservation.model.ReservationAssignment;
import com.example.hotelreservation.model.Staff;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface StaffDao {


    public Staff getStaffById(int staffId);

    public List<Staff> getAllStaff();

    public Staff loginStaff(int staffId, String password);

    public List<ActiveReservationDetails> activeReservations();
}
