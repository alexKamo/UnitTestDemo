package com.UnitTest.DAO;

public interface EmployeeRepository {


    boolean employeeExists(int id);

    String getEmployeeRole(int id);

    int getEmployeeExperience(int id);

    boolean isEligibleForSalaryIncrease(int id);

    int getChildrenAmount(int id);

}
