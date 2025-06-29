package com.exercise2example;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorAppTests {
	
	CalculatorApp calci = new CalculatorApp();

	@Test
	public void testAdd() {
		assertEquals(5, calci.add(2,  3));
	}
	
	@Test
	public void testSubtract() {
		assertEquals(2, calci.subtract(5,  3));
	}
	
	@Test
	public void testMultipy() {
		assertEquals(6, calci.multiply(2,  3));
	}
	
	@Test
	public void testDivide() {
		assertEquals(5, calci.divide(15,  3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() {
		calci.divide(9,  0);
	}

}
