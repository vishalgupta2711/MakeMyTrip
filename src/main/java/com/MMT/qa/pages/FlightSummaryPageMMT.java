package com.MMT.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "//*[contains(@id,\"MANUAL_\")]/div[2]/div/div/div[3]/div/div/label[1]")
	WebElement Male;
	
	@FindBy(xpath = "//*[contains(@id, \"MANUAL_\")]/div[2]/div/div/div[3]/div/div/label[2]")
	WebElement Female;
	
	@FindBy(xpath = "//input[@placeholder = 'Mobile No']")
	WebElement MobNo;
	
	@FindBy(xpath = "//input[@placeholder = 'Email']")
	WebElement Email;
	
	@FindBy(xpath = "//*[contains(text(),'Continue')]")
	WebElement SummaryPageContinueBtn;
	
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
			//Male.click();
			new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(Male)).click();
			 /*JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("arguments[0].click();", Male);*/
		     Thread.sleep(2000);
		}
		else if (Gender.equals(Female)) {
			Female.click();
			Thread.sleep(2000);
		}	
		MobNo.sendKeys(MobNum);
		Email.sendKeys(EmailID);
		
		//First scroll down the page using JavascriptExecutor then click on continue button
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//SummaryPageContinueBtn.click();
		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((SummaryPageContinueBtn))).click();
				
	}
	public TravellerAddOnPageMMT clickOnSummaryPageContinueBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((SummaryPageContinueBtn))).click();
		
		return new TravellerAddOnPageMMT();
		
	}
}
