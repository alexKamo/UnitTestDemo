package com.UnitTest.DAO;

public interface CalculatorRepository {

    int findStoredValue();

    boolean employeeExists(int id);
    String getEmployeeRole(int id);
    int getEmployeeExperience(int id);
}
