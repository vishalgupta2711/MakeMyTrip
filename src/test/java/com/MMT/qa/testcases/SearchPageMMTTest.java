package com.MMT.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MMT.qa.base.TestBaseMMT;
import com.MMT.qa.pages.FlightsHomePageMMT;
import com.MMT.qa.pages.SearchPageMMT;

public class SearchPageMMTTest extends TestBaseMMT{
	
	SearchPageMMT searchPage;
	FlightsHomePageMMT homePageMMT;
	public SearchPageMMTTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		homePageMMT = new FlightsHomePageMMT();
		searchPage = new SearchPageMMT();
		homePageMMT.enterValueOfFromCity();
		homePageMMT.enterValueOfToCity();
		homePageMMT.selectDepartureDate();
		homePageMMT.clickOnSearchBtn();
	}
	
	@Test(priority = 1)
	public void validateFareBtnClickTest() {
		searchPage.clickOnViewFareBtn();
	}
	
	@Test(priority = 2)
	public void bookBtnClickTest() {
		searchPage.clickOnBookNowBtn();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
