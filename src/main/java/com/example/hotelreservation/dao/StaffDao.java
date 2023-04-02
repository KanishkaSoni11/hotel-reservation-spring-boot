package com.example.hotelreservation.dao;

import com.example.hotelreservation.model.Staff;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface StaffDao {


    public Staff getStaffById(int staffId);

    public List<Staff> getAllStaff();
}
