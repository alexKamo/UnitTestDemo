package com.UnitTest.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository{
    @Override
    public int findStoredValue() {
        int a = 8;
        return a;
    }

}
