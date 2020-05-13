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
import com.MMT.qa.pages.TravellerAddOnPageMMT;
import com.MMT.qa.util.TestUtilMMT;

public class TravellerAddOnPageMMTTest extends TestBaseMMT {
	
	FlightsHomePageMMT homePageMMT;
	SearchPageMMT searchPage;
	BookingPageMMT bookingPage;
	FlightSummaryPageMMT summaryPage;
	TravellerAddOnPageMMT travellerPage;
	
	String sheetName = "PassengerDetails";
	
	public TravellerAddOnPageMMTTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		
		bookingPage = new BookingPageMMT();
		homePageMMT = new FlightsHomePageMMT();
		searchPage = new SearchPageMMT();
		summaryPage = new FlightSummaryPageMMT();
		travellerPage = new TravellerAddOnPageMMT();
		
		//HomePage Controls
		
		homePageMMT.enterValueOfFromCity();
		homePageMMT.enterValueOfToCity();
		homePageMMT.selectDepartureDate();
		homePageMMT.clickOnSearchBtn();
		
		//SearchPage Controls
		searchPage.clickOnViewFareBtn();
		searchPage.clickOnBookNowBtn();
		
		//BookingPage Controls
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
		summaryPage.clickOnSummaryPageContinueBtn();
		
	}
	
	@Test(priority = 2)
	public void validateNextBtnClick() {
		travellerPage.clickOnNextBtn();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Program control in Traveller AddOn Page");
		//driver.quit();
	}

}
