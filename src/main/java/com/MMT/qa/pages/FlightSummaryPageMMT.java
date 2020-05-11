package com.MMT.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MMT.qa.base.TestBaseMMT;

public class FlightSummaryPageMMT extends TestBaseMMT {
	
	//PageFactory - OR
	
	@FindBy(xpath = "//a[contains(text(),'+ ADD ADULT')]")
	WebElement AddAdultBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement FlightSummaryContinueBtn;
	
	@FindBy(xpath = "//input[@placeholder = 'First & Middle Name']")
	WebElement FirstNameTextBox;
	
	@FindBy(xpath = "//input[@placeholder = 'Last Name']")
	WebElement LastNameTextBox;
	
	@FindBy(xpath = "//input[@value= 'MALE']")
	WebElement Male;
	
	@FindBy(xpath = "//input[@value= 'FEMALE' and @type= 'radio' ]")
	WebElement Female;
	
	@FindBy(xpath = "//input[@placeholder = 'Mobile No']")
	WebElement MobNo;
	
	@FindBy(xpath = "//input[@placeholder = 'Email']")
	WebElement Email;
	
	public FlightSummaryPageMMT() {
		PageFactory.initElements(driver,this);
	}
	
	public void addPassengerName(String FirstAndMiddleName , String LastName ,
			String Gender , String MobNum , String EmailID) throws InterruptedException {
		AddAdultBtn.click();
		Thread.sleep(1000);
		FirstNameTextBox.sendKeys(FirstAndMiddleName);
		LastNameTextBox.sendKeys(LastName);
		Male.sendKeys(Gender);
		Female.sendKeys(Gender);
		
		if(Gender.equals("MALE")) {
			 JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("arguments[0].click();", Male);
		}
		else if (Gender.equals(Female)) {
			Female.click();
		}	
		MobNo.sendKeys(MobNum);
		Email.sendKeys(EmailID);
	}
}
