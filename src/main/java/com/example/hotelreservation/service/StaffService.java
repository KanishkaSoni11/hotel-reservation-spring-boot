package com.example.hotelreservation.service;

import com.example.hotelreservation.model.ActiveReservationDetails;
import com.example.hotelreservation.model.Staff;

import java.util.List;

public interface StaffService {

    public Staff getStaffById(int staffId);
    public List<Staff> getAllStaff();

    public Staff loginStaff(int staffId, String password);

    public List<ActiveReservationDetails> activeReservations();
}
