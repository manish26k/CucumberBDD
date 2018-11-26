package com.flipkart.pages;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flipkart_RandomOffers_common
{
	static WebDriver driver;
	static ResourceBundle bundle;
	Actions action;
	static WebDriverWait wait;
	
	
// Constructor
	public flipkart_RandomOffers_common(WebDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		action= new Actions(driver);
		//this.wait= new WebDriverWait(driver,5000); 
	}
	
	
	public static void flipkart_Newtab()
	{
		// Store and Print the name of the First/Parent window on the console
		String ParentWindow= driver.getWindowHandle();
		 
        System.out.println(ParentWindow);
        
		//this will click any random product from the homepage.
        //driver.findElement(By.xpath(bundle.getString("Random2ndofferxpath"))).click();
		
		
		
		 // // This will return the number of windows opened by Webdriver and will return Set of Strings   
		Set handles = driver.getWindowHandles();
		 
        System.out.println(handles);
        System.out.println(handles.size());
        
     // Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles())
        {
        	 
        	System.out.println(handle1);

        	driver.switchTo().window(handle1);
        	
        	
     	}
       
        //driver.switchTo().window(ParentWindow);
   }
	
	
	
	public static void flipkart_Text_SizeisPresent() throws InterruptedException
	{
		
		//driver.findElement(By.id(bundle.getString("Sizexpath"))).click();
		
		flipkart_PagetoLoad.waitForLoad(driver,50);
		
        boolean Size= ((RemoteWebDriver) driver).findElementsByCssSelector(bundle.getString("Sizecss")).size()!=0;
        
        boolean Add2cartnotpresentxpath= ((RemoteWebDriver) driver).findElementsByXPath(bundle.getString("Add2cartnotpresentxpath")).size()!=0;
		
		 System.out.println("True means present and false means !present-----Size"+" " +  Size);
		 System.out.println("True means present and false means !present-------Add2cartnotpresentxpath"+" " +  Add2cartnotpresentxpath);
		 
		 
		 
		 if(Size==true)
		 {
			 driver.findElement(By.xpath(bundle.getString("SelectingSizexpath"))).click();
			 //driver.findElement(By.cssSelector(bundle.getString("Whishlistcss"))).click();
			 
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(bundle.getString("add2cartcss"))).click();
		 }
		 
		 
		 else
		 {
			driver.findElement(By.cssSelector(bundle.getString("add2cartcss"))).click();
		 }
		 
	}
	
	
	
	
	public static void flipkart_Filters_dropdown() throws InterruptedException
	{
		//Checking the Price heading text is there or not
		
		/*Thread.sleep(3000);*/
		
		flipkart_PagetoLoad.waitForLoad(driver,50);
		
		boolean price= ((RemoteWebDriver) driver).findElementsByXPath(bundle.getString("Pricexpath")).size()!=0;
		
		System.out.println("True means present and false means !present-------Price"+" " + price);
		
		if(price==true)
		{
			// Selecting the PRice dropdown value
			Select min= new Select(driver.findElement(By.cssSelector(bundle.getString("Mindropdowncss"))));
			min.selectByIndex(0);
										
			Select max= new Select(driver.findElement(By.cssSelector(bundle.getString("Maxdropdowncss"))));
			max.selectByIndex(1);
		}
	}
	
	
	
	public static void flipkart_Filters_Brand() throws InterruptedException
	{
		/*boolean ele= driver.findElementsByXPath(bundle.getString("SearchBrandxpath")).size()!=0;
		System.out.println("True means present and false means !present-------"+ ele);*/
		
		
		
		boolean isBrandOpen= ((RemoteWebDriver) driver).findElementsByXPath(bundle.getString("ifBrandOptionclosedxpath")).size()!=0;
		
		
		
		System.out.println("True means open and false means closed-------Brand"+" "+ isBrandOpen);
		
		
		if(isBrandOpen==true)
		{
			
			
			
			//Using JSE user is click on the 1st checkbox.
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(bundle.getString("NewBrand1stchkBOXxpath")));
			jse.executeScript("arguments[0].click();", element);
			
			Thread.sleep(5000);
			
			/*flipkart_PagetoLoad.waitForLoad(driver,50);*/
			
			driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
			
			String productprice= driver.findElement(By.xpath(bundle.getString("random1stprodpricexpath"))).getText();
			
			System.out.println("Price of the product is ------" + " " + productprice );
		}
		
		
		/*else
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(bundle.getString("newchkboxxpath")));
			jse.executeScript("arguments[0].click();", element);
			
            Thread.sleep(5000);
			
			driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
		}*/
		
		else
		{
			/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bundle.getString("Openbrandxpath")))).click();
			
			driver.findElement(By.xpath(bundle.getString("Openbrandxpath"))).click();
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(bundle.getString("NewBrand1stchkBOXxpath")));
			jse.executeScript("arguments[0].click();", element);
			
			
			driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bundle.getString("random1stprodxpath")))).click();*/
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
		}
	}
	

}




/*
public void flipkart_Filters() throws InterruptedException
{
	//Checking the Price heading text is there or not
	boolean price= driver.findElementsByXPath(bundle.getString("Pricexpath")).size()!=0;
	
	System.out.println(price);
	
	if(price==true)
	{
		// Selecting the PRice dropdown value
		Select min= new Select(driver.findElement(By.cssSelector(bundle.getString("Mindropdowncss"))));
		min.selectByIndex(0);
									
		Select max= new Select(driver.findElement(By.cssSelector(bundle.getString("Maxdropdowncss"))));
		max.selectByIndex(1);
		
		Thread.sleep(5000);
		
		
		//Using JSE user is click on the 1st checkbox.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(bundle.getString("NewBrand1stchkBOXxpath")));
		jse.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
	
	}
	else
	{
	//Checking the Brand heading text is there or not.
	boolean ele= driver.findElementsByXPath(bundle.getString("Brandxpath")).size()!=0;
	System.out.println(ele);
	
	
	//Using JSE user is click on the 1st checkbox.
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.xpath(bundle.getString("NewBrand1stchkBOXxpath")));
	jse.executeScript("arguments[0].click();", element);
				
	Thread.sleep(500);
	
	driver.findElement(By.xpath(bundle.getString("random1stprodxpath"))).click();
	}
	
}*/
