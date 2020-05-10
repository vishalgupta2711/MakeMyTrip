package com.MMT.qa.pages;

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
	
	@FindBy(xpath = "(//input[@value= 'MALE' and @type= 'radio' ])[2]")
	WebElement Male;
	
	@FindBy(xpath = "(//input[@value= 'FEMALE' and @type= 'radio' ])[2]")
	WebElement Female;
	
	public FlightSummaryPageMMT() {
		PageFactory.initElements(driver,this);
	}
	
	public void addPassengerName(String FirstAndMiddleName , String LastName , String Gender) {
		AddAdultBtn.click();
		FirstNameTextBox.sendKeys(FirstAndMiddleName);
		LastNameTextBox.sendKeys(LastName);
		Male.sendKeys(Gender);
		Female.sendKeys(Gender);
		
		if(Gender.equals("MALE")) {
			Male.click();
		}
		else if (Gender.equals(Female)) {
			Female.click();
		}	
		
	}
}
