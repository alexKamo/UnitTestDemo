package com.UnitTest.service;

import com.UnitTest.DAO.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String getInfo(int id) {
        return null;
    }

    @Override
    public boolean isEligibleForPromotion(int id) {
        return false;
    }
}
