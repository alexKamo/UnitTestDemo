package com.UnitTest;

import com.UnitTest.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitTestApplicationTests {

	@Test
	public void shouldReturnCorrectSum(){
		CalculatorService calc = new CalculatorService();

		//given
		int n1 = 5;
		int n2 = 7;
		int expected = 12;

		// when
		int actual = calc.add(n1,n2);
		// then
		Assertions.assertEquals(expected,actual);

	}

	@Test
	public void shouldReturnSquare(){
		CalculatorService calculatorService = new CalculatorService();

		int n = 2;
		int expected = 4;

		int actual = calculatorService.square(n);

		Assertions.assertEquals(expected,actual);
	}

}
