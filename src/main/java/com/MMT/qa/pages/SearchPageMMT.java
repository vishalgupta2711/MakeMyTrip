package com.MMT.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MMT.qa.base.TestBaseMMT;

public class SearchPageMMT extends TestBaseMMT {
	
	
	//PageFactory - OR for search page
	
	@FindBy(xpath = "//button[substring(@id,string-length(@id) -string-length('3_0') +1)        = '3_0']")
	WebElement ViewFaresBtn;
	
	@FindBy(xpath="(//div[@class='faresRightSection']//button[contains(.,'Book Now')])[1]")
	WebElement BookNowBtn;
	
	
	public SearchPageMMT() {
		PageFactory.initElements(driver, this);
	}

	//Actions

	public void clickOnViewFareBtn() {
		ViewFaresBtn.click();
	}
	
	public BookingPageMMT clickOnBookNowBtn() {
		//always include below line of code whenever you are waiting for a button to get clicked.
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((BookNowBtn))).click();
		
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();
		String ParentWindowId = it.next();
		System.out.println(ParentWindowId);
		String ChildWindowId = it.next();
		System.out.println(ChildWindowId);
		driver.switchTo().window(ChildWindowId);
		
	//	BookNowBtn.click();
		return new BookingPageMMT();
	}
}
