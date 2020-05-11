package com.MMT.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestMMT {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		System.out.println("************From City Selection**************");
		
		driver.findElement(By.xpath("//input[@id = 'fromCity']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys("Mumbai");
		
		List <WebElement> listFrom = driver.findElements(By.xpath("//ul[@role ='listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Mumbai, India')]"));
		System.out.println(listFrom.size());
		
		for(int i = 0 ; i<listFrom.size() ; i++) {
			System.out.println(listFrom.get(i).getText());
			if(listFrom.get(i).getText().contains("Mumbai, India")) {
				listFrom.get(i).click();
				break;
			}
		}
		/*JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",From);*/
		
		System.out.println("************To City Selection**************");	
		
		WebElement ToCity = driver.findElement(By.xpath("//input[@id = 'toCity']"));
		
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
		
		System.out.println("---------calendar date picker----------");
		
		String dateVal = "Sun Jun 28 2020";
		WebElement element = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label = '"+dateVal+"']"));
		selectDateByJS(driver,element);		
		
		System.out.println("*************Search button click************");
		
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		
		//view fares button
		driver.findElement(By.xpath("//button[substring(@id,string-length(@id) -string-length('4_0') +1)        = '4_0']")).click();
		
		//book now button
		driver.findElement(By.xpath("(//div[@class='faresRightSection']//button[contains(.,'Book Now')])[1]")).click();
		////div[@class='faresRightSection']//button[contains(.,'Book Now')] This xpath was giving multiple elements ,around 10 elements so I have used index here which gives me the first element. so just appended [1] at last in the xpath
		
		/*List<WebElement> list = driver.findElements(By.xpath("//span[@class = 'actual-price']"));
		
		System.out.println(list.size());
		
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("3075")) {
				
			}
		}*/
		
		
		
		
		
	}

	 public static void selectDateByJS(WebDriver driver,WebElement element) {

	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        js.executeScript("arguments[0].click();", element);

	    }
 
	 		//System.out.println("program end");
			//driver.quit();
	}

