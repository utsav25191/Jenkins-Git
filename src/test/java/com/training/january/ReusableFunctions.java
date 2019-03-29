package com.training.january;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReusableFunctions {

	static WebDriver driver;
	
/*	public static void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishan\\eclipse-workspace\\realApp\\driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		System.out.println("Application launched successfully");
	}
	*/
	public static void enterText(WebElement obj,String textVal) throws InterruptedException {
		
		if(obj.isDisplayed()) {
			Thread.sleep(1000);
			obj.sendKeys(textVal);
			System.out.println("Entering into text field is successful...");
		}else{
			System.out.println("Field does not exist please check");
			
		}
	}
	public static void buttonClicked(WebElement obj) throws InterruptedException {
		if(obj.isDisplayed()) {
			Thread.sleep(2000);
			obj.click();
			System.out.println("Button clicked successfully");
		}else {
			System.out.println("No Button exist...");
		}
	}
	
	public static void selectByIndex(WebElement obj,int value) throws InterruptedException {
		
		if(obj.isDisplayed()){
			Select select = new Select(obj);
			Thread.sleep(2000);
			select.selectByIndex(value);
			System.out.println("Elemenet clicked successful");
		}	else {
		System.out.println("Element is not clicked successfully..."); 
			
		}
			
		
	}
	public static void selectByName(WebElement obj,String value) throws InterruptedException {
		if(obj.isDisplayed()) {
			Select select = new Select(obj);
			Thread.sleep(2000);
			select.selectByValue(value);
			System.out.println("Elemenet clicked successful");
			
		}else{
			System.out.println("Element is not clicked successfully..."); 
				
			}
	}
	
	
	
}
