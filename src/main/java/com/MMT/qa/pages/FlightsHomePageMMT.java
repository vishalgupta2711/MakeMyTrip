package com.MMT.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MMT.qa.base.TestBaseMMT;

public class FlightsHomePageMMT extends TestBaseMMT {
	
	//Page Factory - OR for Home page
	
	@FindBy(xpath = "//input[@id = 'fromCity']")
	WebElement FromCity;
	
	@FindBy(xpath = "//input[@placeholder = 'From']")
	WebElement FromTextFromCity;
	
	@FindBy(xpath = "//input[@id = 'toCity']")
	WebElement ToCity;
	
	@FindBy(xpath = "//input[@placeholder = 'To']")
	WebElement FromTextToCity;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement SrchBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement SearchBtn;
	
	/*@FindBy(xpath = "//div[@class = 'fsw_inputBox dates inactiveWidget ']")
	WebElement DepDateSelect;*/
	
	public FlightsHomePageMMT() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterValueOfFromCity() {
		FromCity.click();
		FromTextFromCity.sendKeys("Mumbai");
		List <WebElement> listFrom = driver.findElements(By.xpath("//ul[@role ='listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Mumbai, India')]"));
		System.out.println(listFrom.size());
		
		for(int i = 0 ; i<listFrom.size() ; i++) {
			System.out.println(listFrom.get(i).getText());
			if(listFrom.get(i).getText().contains("Mumbai, India")) {
				listFrom.get(i).click();
				break;
			}
		}
	}
	
	public void enterValueOfToCity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",ToCity);
		
		driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys("tirupati");
		
		List <WebElement> listTo = driver.findElements(By.xpath("//ul[@role ='listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Tirupati, India')]"));
		System.out.println(listTo.size());
		
		for(int i = 0 ; i<listTo.size() ; i++) {
			System.out.println(listTo.get(i).getText());
			if(listTo.get(i).getText().contains("Tirupati, India")) {
				listTo.get(i).click();
				break;
			}
		}
	}
	
	public void selectDepartureDate() {
		//DepDateSelect.click();
		 String dateVal = "Sun Jun 28 2020";
		try {
		 WebElement element = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label = '"+dateVal+"']"));
		 selectDateByJS(driver,element);
		}catch(NoSuchElementException e) {
			System.out.println("Date selected by JS");
		}
		 
	}
	 public static void selectDateByJS(WebDriver driver,WebElement element) {
		 
	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        js.executeScript("arguments[0].click();", element);
	 }
	 
	 public SearchPageMMT clickOnSearchBtn() {
		 SearchBtn.click();
		 return new SearchPageMMT();
	 }
}

