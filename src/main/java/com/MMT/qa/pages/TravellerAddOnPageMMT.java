package com.MMT.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MMT.qa.base.TestBaseMMT;

public class TravellerAddOnPageMMT extends TestBaseMMT {
	
	//PageFactory - OR
	
	@FindBy(xpath = "//a[@id = 'ancillary-continue']")
	WebElement NextBtn;
	
	@FindBy(xpath = "//a[contains(text(),'CONTINUE ANYWAY')]")
	WebElement ContinueAnywayBtn;
	
	
	public TravellerAddOnPageMMT() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnNextBtn() {

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((NextBtn))).click();
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(ContinueAnywayBtn)).click();
	}
}
