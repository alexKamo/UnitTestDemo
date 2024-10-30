package com.UnitTest;

import com.UnitTest.DAO.EmployeeRepository;
import com.UnitTest.service.EmployeeService;
import com.UnitTest.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeTestClass {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnNoSuchEmployee(){

        String expected = "noSuchEmployee";
        int id = 5;
        when(employeeRepository.employeeExists(id)).thenReturn(false);
        String actual = employeeService.getInfo(id);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void shouldReturnAnyEmployee(){
        int id = 7;
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
