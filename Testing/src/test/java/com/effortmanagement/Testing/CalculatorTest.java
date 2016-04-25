package com.effortmanagement.Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {
	private static Calculator calc;
	
	@BeforeClass
	public static void setUpClass(){
		calc = new Calculator();
	}
	
	@Test
	public void testPlus() {
		Assert.assertEquals(calc.plus(5, 7), 12.0);
		Assert.assertEquals(calc.plus(5, 0), 5.0);
		Assert.assertEquals(calc.plus(0, 7), 7.0);
	}

	@Test
	public void testMinus() {
		Assert.assertEquals(calc.minus(5, 7), -2.0);
		Assert.assertEquals(calc.minus(5, 0), 5.0);
		Assert.assertEquals(calc.minus(0, 7), -7.0);
	}

	@Test
	public void testMulti() {
		Assert.assertEquals(calc.multi(5, 7), 35.0);
		Assert.assertEquals(calc.multi(5, 0), 0.0);
		Assert.assertEquals(calc.multi(0, 7), 0.0);
		Assert.assertEquals(calc.multi(-10, 7), -70.0);
	}

	@Test
	public void testDivide() {
		Assert.assertEquals(calc.divide(50, 5), 10.0);
		Assert.assertEquals(calc.divide(-10, 2), -5.0);
		Assert.assertEquals(calc.divide(0, 7), 1.0);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideThroughNull() {
		calc.divide(5, 0);
	}
	
	@Test
	public void testSquare() {
		Assert.assertEquals(calc.square(3, 2), 9.0);
		Assert.assertEquals(calc.square(-10, 2), 100.0);
		Assert.assertEquals(calc.square(0, 7), 0.0);
		Assert.assertEquals(calc.square(7, 0), 1.0);
	}

	@Test
	public void testSquareRoot() {
		Assert.assertEquals(calc.squareRoot(25), 5.0);
		Assert.assertEquals(calc.squareRoot(100), 10.0);
		Assert.assertEquals(calc.squareRoot(144), 12.0);
		Assert.assertEquals(calc.squareRoot(0), 0.0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testSquareRootNegative() {
		calc.squareRoot(-100);
	}

}
