package com.flipkart.pages;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flipkart_Cart
{
	WebDriver driver;
	ResourceBundle bundle;
	Actions action;
	WebDriverWait wait;
	public ResourceBundle rb;
	
	
// Constructor
	public flipkart_Cart(WebDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		action= new Actions(driver);
		this.wait= new WebDriverWait(driver,5000); 
	}
	
	
	public void flipkart_cartQunatity() throws InterruptedException, IOException
	{
		
		//here i am checking weather after adding the prod in the cart is present or not
		// if the element is present it displayed true  or else it displayed false.
		
		
		
		boolean exists= ((RemoteWebDriver) driver).findElementsByCssSelector(bundle.getString("Cartquantcss")).size()!=0;
		
		System.out.println("True means present and false means !present-----exists"+" " +  exists);
		
		
		
		
		
		driver.findElement(By.cssSelector(bundle.getString("Cartcss"))).click();
		
		Thread.sleep(2000);
		
		String prodname= driver.findElement(By.xpath(bundle.getString("prodnameinCart"))).getText();
		
		//flipkart_Screenshot.takeSnapShot(driver, "productName");
		
		System.out.println(prodname);
		
		String prodpriceinCart= driver.findElement(By.xpath(bundle.getString("prodpriceinCart"))).getText();
		
		System.out.println("Price of the product on Cart is ------" + " " + prodpriceinCart);
	}
	
	
	public void fullcartProductname()
	{
         List<WebElement> pName= driver.findElements(By.xpath(bundle.getString("prodblockxpath")));
	    
	    System.out.println(pName.size());
	    
	    for(int j=0;j<pName.size();j++)
	    {
	    	    	
	    	System.out.println(pName.get(j).getText());
	    }
	}
	
	
	
	
	
	
	
	
}
