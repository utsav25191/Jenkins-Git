package com.training.january;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class HomePage extends ReusableFunctions {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {	
		//Making of Extent Report
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Report1.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//Test Case -1
		ExtentTest logger=extent.createTest("Launch Browser");
		logger.log(Status.INFO, "Launch the website");
		logger.log(Status.PASS, "Launched Successfully");
		launch();
		Thread.sleep(5000);
		extent.flush();
		
		//Test Case -2
		ExtentTest logger1=extent.createTest("Login");
		logger1.log(Status.INFO, "Login to Salesforce");
		logger1.log(Status.PASS, "Login Successfully");
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		enterText(emailUserName, "admin123@gmail.com");
		
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		
		WebElement login = driver.findElement(By.xpath(" //button[@onclick='login()']"));
		buttonClicked(login);
		extent.flush();
		
		
		//Test Case -3
		ExtentTest logger2=extent.createTest("HomePage");
		logger2.log(Status.INFO, "Click on Home Tab");
		logger2.log(Status.PASS, "Move successfully on Home Page");
		WebElement homeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		Thread.sleep(1000);
		buttonClicked(homeTab);
		extent.flush();
		
		//Test Case -4
		ExtentTest logger3=extent.createTest("Information Page");
		logger3.log(Status.INFO, "Filling information one by one");
		logger3.log(Status.PASS, "Information filled successfully");
		
		WebElement name = driver.findElement(By.id("name"));
		enterText(name, "Utsav");
		
		WebElement lname = driver.findElement(By.id("lname"));
		enterText(lname, "Patel");
		
		WebElement Paddress=driver.findElement(By.id("postaladdress"));
		enterText(Paddress, "malav bhagol");
		
		WebElement address = driver.findElement(By.id("personaladdress"));
		enterText(address, "Anand");
		
		WebElement Gender = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[5]/span[1]"));
		buttonClicked(Gender);
		
	
		WebElement city =  driver.findElement(By.id("city"));
		selectByIndex(city, 2);
		
	
		
		WebElement course = driver.findElement(By.id("course"));
		selectByName(course,"mca");
		
		WebElement district = driver.findElement(By.id("district"));
		selectByName(district, "goa");
		
		WebElement state = driver.findElement(By.id("state"));
		selectByIndex(state, 2);

		WebElement pincode= driver.findElement(By.id("pincode"));
		enterText(pincode, "388222");
		
		WebElement email = driver.findElement(By.id("emailid"));
		enterText(email, "anxs143@gmail.com");
		email.clear();
		
		WebElement submit = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		buttonClicked(submit);
		Thread.sleep(5000);
		
		extent.flush();
		
		//---------------------------------Home Page login done------------------------------------------------
		//switch to tab actions
		
		ExtentTest logger4=extent.createTest("Switch To Page");
		logger4.log(Status.INFO, "Click on Switch to Page and check alert");
		logger4.log(Status.PASS, "checked Alert and its working great");
		
		WebElement Switchtoo= driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		buttonClicked(Switchtoo);
		
		WebElement alert = driver.findElement(By.xpath(" //a[contains(text(),'Alert')]"));
		buttonClicked(alert);
		
		WebElement windowsAlert = driver.findElement(By.xpath(" //button[contains(text(),'Window Alert')]"));
		buttonClicked(windowsAlert);
		
		extent.flush();
				
	
	}
	public static void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishan\\eclipse-workspace\\realApp\\driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		System.out.println("Application launched successfully");
	}
}
