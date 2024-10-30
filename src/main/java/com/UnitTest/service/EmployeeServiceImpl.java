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
        String info = "noSuchEmployee";
        if (employeeRepository.employeeExists(id)){
            info = "employeeId " + id + " role " + employeeRepository.getEmployeeRole(id)
                    + " experience " + employeeRepository.getEmployeeExperience(id);
        }
        return info;
    }

    @Override
    public boolean isEligibleForPromotion(int id) {
        if (employeeRepository.getEmployeeExperience(id)>5) return true;
        return false;
    }
}
