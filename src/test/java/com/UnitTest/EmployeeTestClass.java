package com.UnitTest;

import com.UnitTest.DAO.EmployeeRepository;
import com.UnitTest.service.EmployeeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

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

    @AfterEach
    void afterEach(){
        System.out.println("Say hi from after Each");
    }

    @AfterAll
    static void
    afterAll() {

        System.out.println("Say hi from after All");
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

    @Test
    void shouldNotGetPromotion(){
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(1);
        boolean result = employeeService.isEligibleForPromotion(id);
        Assertions.assertFalse(result);

    }

    @Test
    void shouldGetPromotion(){
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(9);
        boolean result = employeeService.isEligibleForPromotion(id);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnTrueForSalaryIncrease(){
            // given:
        int exp = 10;
        int childrenAmount = 3;
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(exp);
        when(employeeRepository.getChildrenAmount(id)).thenReturn(childrenAmount);

        Object[] arr = employeeService.isEligibleForSalaryIncrease(id);

        Assertions.assertTrue((Boolean) arr[0]);
        Assertions.assertEquals("Eligible", arr[1]);

        Object[] expected = new Object[]{true, "Eligible"};
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(arr));
    }

    @Test
    @DisplayName("shouldReturnFalseForSalaryIncreaseWithReasonNoEnoughExperience")
    void noEnExp(){
        int exp = 1;
        int childrenAmount = 4;
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(exp);
        when(employeeRepository.getChildrenAmount(id)).thenReturn(childrenAmount);
        Object[] arr = employeeService.isEligibleForSalaryIncrease(id);
        Assertions.assertFalse((Boolean) arr[0]);
        Assertions.assertEquals("Not enough experience, less then 7",arr[1]);
        Object[] expected = new Object[]{false,"Not enough experience, less then 7"};
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(arr));
    }

    @Test
    void shouldReturnTrueForSalaryIncreaseWithReasonNoEnoughChildren(){
        int exp = 10;
        int childrenAmount = 1;
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(exp);
        when(employeeRepository.getChildrenAmount(id)).thenReturn(childrenAmount);
        Object[] arr = employeeService.isEligibleForSalaryIncrease(id);
        Assertions.assertFalse((Boolean) arr[0]);
        Assertions.assertEquals("Not enough children",arr[1]);
        Object[] expected = new Object[]{false,"Not enough children"};
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(arr));
    }


    @Test
    void shouldReturnTrueForSalaryIncreaseWithManyReason(){

        int exp = 2;
        int childrenAmount = 2;
        when(employeeRepository.getEmployeeExperience(id)).thenReturn(exp);
        when(employeeRepository.getChildrenAmount(id)).thenReturn(childrenAmount);

        Object[] arr = employeeService.isEligibleForSalaryIncrease(id);

        Assertions.assertFalse((Boolean) arr[0]);
        Assertions.assertEquals("Many reasons", arr[1]);

        Object[] expected = new Object[]{false, "Many reasons"};
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(arr));
    }

    @Test
    @DisplayName("negative id test")
    void shouldThrowError(){
        id = -4;
        Executable executable = () -> employeeService.getInfo(id);
        Assertions.assertThrows(RuntimeException.class,executable);
    }



}
