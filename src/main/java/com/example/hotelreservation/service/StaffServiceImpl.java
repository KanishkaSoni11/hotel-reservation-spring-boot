package com.example.hotelreservation.service;

import com.example.hotelreservation.dao.StaffDao;
import com.example.hotelreservation.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffDao staffDao;


    @Override
    public Staff getStaffById(int staffId) {
        return staffDao.getStaffById(staffId);
    }

    @Override
    public List<Staff> getAllStaff(){
        return staffDao.getAllStaff();
    }
}
