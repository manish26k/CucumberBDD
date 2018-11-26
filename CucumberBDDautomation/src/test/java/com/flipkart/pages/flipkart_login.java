package com.flipkart.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flipkart_login
{
	WebDriver driver;
	ResourceBundle bundle;
	ResourceBundle bundle1;
	Actions action;
	WebDriverWait wait;

// Constructor
	public flipkart_login(WebDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		bundle1=ResourceBundle.getBundle("Config");
		action= new Actions(driver);
		
		 //this.wait= new WebDriverWait(driver,10); 
	}
	
	
	/*public void flipkart_login()
	{
		
		//entering mobile number in the email field
		//driver.findElement(By.xpath(bundle.getString("loginemailxpath"))).sendKeys("8447704863");
		
		driver.findElement(By.xpath(bundle.getString("loginemailxpath"))).sendKeys(bundle1.getString("Email"));
		driver.findElement(By.xpath(bundle.getString("loginpasswordxpath"))).sendKeys(bundle1.getString("Password"));
		
		//driver.findElement(By.xpath(bundle.getString("loginpasswordxpath"))).sendKeys("Fl1pk@rt");
		driver.findElement(By.xpath(bundle.getString("loginbuttonxpath"))).click();
	}*/
	
	public void flipkart_login_username(String username)
	{
		
		driver.findElement(By.xpath(bundle.getString("loginemailxpath"))).sendKeys(username);
		
		
	}
	
	public void flipkart_login_password(String password)
	{
		driver.findElement(By.xpath(bundle.getString("loginpasswordxpath"))).sendKeys(password);
		
		
	}
	
	public void flipkart_login_clickbutton()
	{
		
		driver.findElement(By.xpath(bundle.getString("loginbuttonxpath"))).click();
	}
	

}
