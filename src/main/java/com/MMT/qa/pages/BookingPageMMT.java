package com.MMT.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MMT.qa.base.TestBaseMMT;

public class BookingPageMMT extends TestBaseMMT {
	
	//PageFactory - OR
	
	@FindBy(xpath = "//button[@id = 'review-continue']")
	WebElement ContinueBtn;
	
	@FindBy(xpath = "//input[@value = 'no']")
	WebElement iDonotWishToSecureMyTripRadioBtn;
	
	//initializing the Object repository
	
	public BookingPageMMT() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinueBtn() {
		
		//First scroll down the page using JavascriptExecutor then click on continue button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",iDonotWishToSecureMyTripRadioBtn);
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",ContinueBtn);
		
		
		//iDonotWishToSecureMyTripRadioBtn.click();
		//	new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(iDonotWishToSecureMyTripRadioBtn)).click();
		//new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
		//ContinueBtn.click();
	}
	

}
