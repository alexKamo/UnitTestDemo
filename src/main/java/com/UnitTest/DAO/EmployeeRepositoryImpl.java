package com.UnitTest.DAO;

public class EmployeeRepositoryImpl implements EmployeeRepository{



    @Override
    public boolean employeeExists(int id) {
        System.out.println("Run query to find employee with given Id");
        // if id from db equals to the id from method atg then return true
        // else return false
        return false;
    }

    @Override
    public String getEmployeeRole(int id) {
        String role = "noRole";
        if (employeeExists(id)){
            System.out.println("Run query to find employee role with given Id");
            role = "developer";
        }
        return role;
    }

    @Override
    public int getEmployeeExperience(int id) {
        if (employeeExists(id)) return 22;
        return 0;
    }
}
