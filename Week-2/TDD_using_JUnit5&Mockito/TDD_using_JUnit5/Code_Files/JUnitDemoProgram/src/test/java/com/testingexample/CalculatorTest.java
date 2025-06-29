package com.testingexample;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calci = new Calculator();
		int result = calci.add(2,  3);
		assertEquals(5, result);
	}
	
	@Test
	public void testMul() {
		Calculator calci = new Calculator();
		int result = calci.mul(2,  3);
		assertEquals(6, result);
	}

}
