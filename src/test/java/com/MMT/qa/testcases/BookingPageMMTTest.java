package com.MMT.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MMT.qa.base.TestBaseMMT;
import com.MMT.qa.pages.BookingPageMMT;
import com.MMT.qa.pages.FlightsHomePageMMT;
import com.MMT.qa.pages.SearchPageMMT;

public class BookingPageMMTTest extends TestBaseMMT {
	
	BookingPageMMT bookingPage;
	FlightsHomePageMMT homePageMMT;
	SearchPageMMT searchPage;
	
	public BookingPageMMTTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		bookingPage = new BookingPageMMT();
		homePageMMT = new FlightsHomePageMMT();
		searchPage = new SearchPageMMT();
		homePageMMT.enterValueOfFromCity();
		homePageMMT.enterValueOfToCity();
		homePageMMT.selectDepartureDate();
		homePageMMT.clickOnSearchBtn();
		searchPage.clickOnViewFareBtn();
		searchPage.clickOnBookNowBtn();
	}
	
	@Test
	public void validateBookingPageContinueBtnClick() {
		bookingPage.clickOnContinueBtn();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Program successfully reached till continue button");
		//driver.quit();
	}

}
