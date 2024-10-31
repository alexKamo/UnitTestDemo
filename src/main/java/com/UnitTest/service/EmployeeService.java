package com.UnitTest.service;

public interface EmployeeService {

    String getInfo(int id);

    boolean isEligibleForPromotion(int id);

    boolean isEligibleForSalaryIncrease(int id);

    int getChildrenAmount(int id);
}
