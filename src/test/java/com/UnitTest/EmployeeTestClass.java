package com.UnitTest;

import com.UnitTest.DAO.EmployeeRepository;
import com.UnitTest.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class EmployeeTestClass {

    private int id;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp(){
        id = 88;
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnNoSuchEmployee(){

        String expected = "noSuchEmployee";
        when(employeeRepository.employeeExists(id)).thenReturn(false);
        String actual = employeeService.getInfo(id);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void shouldReturnAnyEmployee(){
        String role = "developer";
        int  experience = 6;
        String expected = "employeeId " + id + " role " + role
                + " experience " + experience;
        when(employeeRepository.employeeExists(id)).thenReturn(true);
        when(employeeRepository.getEmployeeRole(id)).thenReturn(role);
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(experience);
        String actual = employeeService.getInfo(id);
        Assertions.assertEquals(expected,actual);

    }
}
