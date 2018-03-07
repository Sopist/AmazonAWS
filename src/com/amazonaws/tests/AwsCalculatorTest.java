package com.amazonaws.tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.amazonaws.pages.AwsCalculatorPage;
import com.amazonaws.utilities.TestBaseClass;

public class AwsCalculatorTest extends TestBaseClass {

	AwsCalculatorPage calculator = new AwsCalculatorPage(); // All method can use

	@Test(priority = 0, description = "Monthly bill should be $0.00 by default")
	public void defaultMonthlyBillTest() {
		assertTrue(calculator.isAt());
		assertEquals(calculator.getMonthlyBill(), 0.0);
	}
	
	@Test(priority = 1)
	public void addEC2Test() {
		calculator.addEC2.click();
		assertTrue(calculator.description.getAttribute("value").isEmpty());
		assertEquals(calculator.getInstanceCount(), 1);
		assertTrue(calculator.usage.getAttribute("value").equals("100"));
		
//		System.out.println(calculator.usageList.getAttribute("value").);
	}
	
	
	
}
