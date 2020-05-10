package com.MMT.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MMT.qa.base.TestBaseMMT;
import com.MMT.qa.pages.FlightsHomePageMMT;

public class FlightsHomePageMMTTest extends TestBaseMMT {
	
	FlightsHomePageMMT homePageMMT ;
	
	public FlightsHomePageMMTTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		homePageMMT = new FlightsHomePageMMT();
	}
	
	@Test(priority = 1)
	public void validateCitySelection() {
		
		homePageMMT.enterValueOfFromCity();
		homePageMMT.enterValueOfToCity();
		homePageMMT.selectDepartureDate();
		System.out.println("city selection successfull");
	}
	
	@Test(priority = 2)
	public void validateDateSelection() {
		homePageMMT.selectDepartureDate();
		System.out.println("Date selection successful");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("All selections done and program ended successfully :");
		driver.quit();
	}

}
