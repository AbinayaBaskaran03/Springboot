package com.app.onetomany.onetomany;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.onetomany.controller.UnitTesting;
public class UnitTestClass {

//UnitTesting unitTesting;	
//	@BeforeEach
//	public void setUp() {
//		UnitTesting	unitTesting = new UnitTesting();
//	}

	UnitTesting unitTesting = new UnitTesting();

	@Test
	public void testMultiply() {
		assertEquals(20, unitTesting.multiply(4, 5));
	}

	@Test
	public void testAdd() {
		assertEquals(9, unitTesting.add(4, 5));

	}
	@Test
	public void testDivide() {
		assertEquals(2, unitTesting.divide(4, 2));
	}

}
