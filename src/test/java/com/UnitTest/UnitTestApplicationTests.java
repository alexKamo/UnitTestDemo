package com.UnitTest;

import com.UnitTest.DAO.CalculatorRepository;
import com.UnitTest.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.when;

//@SpringBootTest
class UnitTestApplicationTests {


	@Mock            // creates a mock version of CalculatorRepository
	private CalculatorRepository calculatorRepository;

	@InjectMocks    // Inject the mock repository into the calculatorService
	private CalculatorService calculatorService;

	@BeforeEach     // runs before every test: you can put any logics
	public void setUp(){
		System.out.println("Hello from setUp method");
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAndAdd(){
		int n1 = 5; int n2 = 15;
		when(calculatorRepository.findStoredValue()).thenReturn(8);
		int actual = calculatorService.findAndAdd(n1,n2);
		int expected = 28;
		Assertions.assertEquals(expected,actual);
	}


	@Test
	public void shouldReturnCorrectSum(){
	//	CalculatorService calc = new CalculatorService();

		//given
		int n1 = 5;
		int n2 = 7;

		int expected = 12;

		// when
		int actual = calculatorService.add(n1,n2);
		// then
		Assertions.assertEquals(expected,actual);

	}

	@Test
	public void shouldReturnSquare(){
	//	CalculatorService calculatorService = new CalculatorService();

		int n = 2;
		int expected = 4;

		int actual = calculatorService.square(n);

		Assertions.assertEquals(expected,actual);
	}

	@Test
	@DisplayName("division test")
	void divide(){
		int n1 = 6;
		int n2 = 3;
		double expected = n1/n2;
		double actual = calculatorService.divide(n1,n2);
		Assertions.assertEquals(expected,actual);
	}

	@Test
	@DisplayName("division test with zero")
	void divideWithZero(){
		int n1 = 6;
		int n2 = 0;
		Executable executable = () -> calculatorService.divide(n1,n2);
		Assertions.assertThrows(ArithmeticException.class, executable);
	}
}
