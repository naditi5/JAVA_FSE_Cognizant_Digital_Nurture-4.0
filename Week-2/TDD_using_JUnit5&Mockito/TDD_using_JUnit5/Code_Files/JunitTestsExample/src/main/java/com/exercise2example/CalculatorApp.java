package com.exercise2example;

public class CalculatorApp {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int divide(int a, int b) {
		if(b == 0)
			throw new IllegalArgumentException("Divider cannot be zero");
		return a / b;
	}

}
