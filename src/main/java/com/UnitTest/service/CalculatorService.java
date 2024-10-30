package com.UnitTest.service;

import com.UnitTest.DAO.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private CalculatorRepository calculatorRepository;

    @Autowired
    public CalculatorService (CalculatorRepository calculatorRepository){
        this.calculatorRepository = calculatorRepository;
    }

    public int  findAndAdd(int a, int b){
        return a+b+calculatorRepository.findStoredValue();
    }

    public int add(int a, int b){
        return a+b;
    }


    public int square(int a){
        return a*a;
    }
}
