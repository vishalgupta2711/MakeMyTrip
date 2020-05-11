package com.MMT.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MMT.qa.base.TestBaseMMT;
import com.MMT.qa.pages.BookingPageMMT;
import com.MMT.qa.pages.FlightSummaryPageMMT;
import com.MMT.qa.pages.FlightsHomePageMMT;
import com.MMT.qa.pages.SearchPageMMT;
import com.MMT.qa.util.TestUtilMMT;

public class FlightSummaryPageMMTTest extends TestBaseMMT{
	
	FlightsHomePageMMT homePageMMT;
	SearchPageMMT searchPage;
	BookingPageMMT bookingPage;
	FlightSummaryPageMMT summaryPage;
	
	String sheetName = "PassengerDetails";
	
	public FlightSummaryPageMMTTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		bookingPage = new BookingPageMMT();
		homePageMMT = new FlightsHomePageMMT();
		searchPage = new SearchPageMMT();
		summaryPage = new FlightSummaryPageMMT();
		homePageMMT.enterValueOfFromCity();
		homePageMMT.enterValueOfToCity();
		homePageMMT.selectDepartureDate();
		homePageMMT.clickOnSearchBtn();
		searchPage.clickOnViewFareBtn();
		searchPage.clickOnBookNowBtn();
		bookingPage.clickOnContinueBtn();
		
	}
	
	@DataProvider
	public Object[][] validateGetPaggengerDetailsFromExcel() {
		Object data[][] = TestUtilMMT.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "validateGetPaggengerDetailsFromExcel")
	public void validatePassengerData(String FirstAndMiddleName , String LastName ,
			String Gender , String MobNum , String EmailID) throws InterruptedException {
		summaryPage.addPassengerName(FirstAndMiddleName, LastName, Gender, MobNum, EmailID);
		
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("program reached end");
		driver.quit();
	}

}
