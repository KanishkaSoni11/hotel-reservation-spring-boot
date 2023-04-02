package com.example.hotelreservation.service;

import com.example.hotelreservation.model.Staff;

import java.util.List;

public interface StaffService {

    public Staff getStaffById(int staffId);
    public List<Staff> getAllStaff();
}
