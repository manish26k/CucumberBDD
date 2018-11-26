package com.flipkart.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart_PagetoLoad
{
	WebDriver driver;
	ResourceBundle bundle;
	Actions action;
	WebDriverWait wait;
	
	
// Constructor
	public flipkart_PagetoLoad(ChromeDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		action= new Actions(driver);
		//this.wait= new WebDriverWait(driver,5000); 
	}
	
	public static void waitForLoad(WebDriver driver, int timeout)
	{
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>()
        {
          public Boolean apply(WebDriver driver)
          {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
          }
       };
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(pageLoadCondition);
    }

}
