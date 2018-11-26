package com.flipkart.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class flipkart_createdriver {
	
	public WebDriver driver;
	public ResourceBundle rb;

	
	
	public WebDriverWait wait;
	
	
	public void openBrowser()
	{
		rb= ResourceBundle.getBundle("Config");
		//System.setProperty("webdriver.chrome.driver","C:/Users/dell/Desktop/Selenium/software/chromedriver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(rb.getString("URL"));
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,5);
		//driver.manage().deleteAllCookies();
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
				
	}
	
	
	

}
