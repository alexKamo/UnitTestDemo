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

    /**
     * employee salary can be increase if:
     *  - emp is eligible for promotion
     *  - emp experience > 7
     *  - emp children amount >= 3
     *  all three condition is true
     * @param id
     * @return
     */

    @Override
    public boolean isEligibleForSalaryIncrease(int id) {
        if (isEligibleForSalaryIncrease(id) && employeeRepository.getEmployeeExperience(id) > 5 && getChildrenAmount(id) >= 3){
            return true;
        }
        return false;
    }

    @Override
    public int getChildrenAmount(int id) {
        // here you have a query to get amount of children from given emp id
        // select Count(*) from employees, dependents where employee.id = dependent.id
        return employeeRepository.getChildrenAmount(id);
    }
}
