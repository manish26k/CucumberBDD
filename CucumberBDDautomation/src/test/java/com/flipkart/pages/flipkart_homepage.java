package com.flipkart.pages;

import java.io.IOException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.flipkart.base.flipkart_createdriver;

public class flipkart_homepage 
{
	WebDriver driver;
	ResourceBundle bundle;
	Actions action;
	WebDriverWait wait;
	
	
	
// Constructor
	public flipkart_homepage(WebDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		action= new Actions(driver);
		
		 this.wait= new WebDriverWait(driver,500); 
	}


	public void flipkart_headerMenu() throws IOException 
	{
	
	//flipkart_Screenshot.takeSnapShot(driver, "Homepage");
		
	List<WebElement> Menu=driver.findElements(By.xpath(bundle.getString("HeaderMenuxpath")));
	System.out.println("headerMenu list of name" + Menu.size());
	
	for(int i=0;i<Menu.size();i++)
	{
		System.out.println(driver.findElements(By.xpath(bundle.getString("HeaderMenuxpath"))).get(i).getText());
		
		if(driver.findElements(By.xpath(bundle.getString("HeaderMenuxpath"))).get(i).getText().contains("Electronics"))
		{
			/*Stale Element Reference exception: "stale element reference element is not attached to the page document" 
			 * when ever such type of expection if we face then we can use 2 methods listed below:
			 * 1. refresh the page and again try for the same element.
			 *     Driver.navigate().refersh();
			 *     Driver.findElement(By.id(�ur element id�)).click();
			 *     
			 * 2. Sometimes it takes the time to attach element on Dom so you can retry using for loop and try catch.
			 *    which is used in the below.    
		 */
		
		
			for(int k=0;k<2;k++)
			{
				try
				{
					//mouse over on the electornics header menu
					action.moveToElement(driver.findElement(By.xpath(bundle.getString("Electronicsheadermenuxpath")))).perform();
					//display the electronics menu list EML
					List<WebElement> EML= driver.findElements(By.cssSelector(bundle.getString("Electronicsmenulistcss")));
					System.out.println("Electronics menu list is " + EML.size());
					
					for(int j=0;j<EML.size();j++)
					{
						//getting the names of electronics menu list name using "gettext()"
					System.out.println(driver.findElements(By.cssSelector(bundle.getString("Electronicsmenulistcss"))).get(j).getText());
					if(driver.findElements(By.cssSelector(bundle.getString("Electronicsmenulistcss"))).get(j).getText().contains("Mi"))
					{
						driver.findElement(By.cssSelector(bundle.getString("MiElectronicscss"))).click();
						
						
					}
					else
					{
						System.out.println("The element is not found");
					}
						
					}
					
					break;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
		
		
		
}
	
	
	public void flipkart_FeatureBrands() 
	{
		
		flipkart_PagetoLoad.waitForLoad(driver,50);
		
		
		
		WebElement fblist= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bundle.getString("FeatureBrandlistxpath")))); 
		
		
		/*WebElement fblist= driver.findElement(By.xpath(bundle.getString("FeatureBrandlistxpath")));*/
		
         System.out.println(fblist.findElements(By.tagName("a")).size());
          
         
          for(int k=0;k<fblist.findElements(By.tagName("a")).size();k++)
          {
        	
        	  System.out.println(fblist.findElements(By.tagName("a")).get(k).getAttribute("title"));
        	  if(fblist.findElements(By.tagName("a")).get(k).getAttribute("title").equals("Whirlpool"))
        	  {
        		 WebDriverWait wait= new WebDriverWait(driver,10); 
        		 wait.until(ExpectedConditions.elementToBeClickable(fblist.findElements(By.tagName("a")).get(k))).click();
        		  break;
       	      }
        	  
        	  else
        	  {
        		 fblist.findElement(By.xpath(bundle.getString("FeatureBrandNextbuttonxpath"))).click();
        		 WebElement element= driver.findElement(By.xpath(bundle.getString("FeatureBrandlistxpath")));
        		 JavascriptExecutor executor = (JavascriptExecutor)driver;
        		 executor.executeScript("arguments[0].click();", element);
       		 // wait.until(ExpectedConditions.elementToBeClickable(fblist.findElements(By.tagName("a")).get(k))).click();
        		  
        	  }
       } 
          
	}         
        	
	
	
	
	
	public void flipkart_RandomOffers() throws InterruptedException
	{
		List<WebElement> RandomOffers= driver.findElements(By.xpath(bundle.getString("Randomofferxpath")));
		
		
		
		System.out.println(RandomOffers.size());
		
		
		for(int i=0;i<RandomOffers.size();i++)
		{
			System.out.println(driver.findElements(By.xpath(bundle.getString("Randomofferxpath"))).get(i).getText());
			String Open=driver.findElement(By.xpath(bundle.getString("Random2ndofferxpath"))).getAttribute("target");
			System.out.println("Link should open in same page or new tab" +" "+ Open);
			
			flipkart_RandomOffers_common ABC= new flipkart_RandomOffers_common(driver);

			if(Open.equals("_blank"))
			{
				System.out.println("link gonna be open in new tab"+driver.getCurrentUrl());
				
				//to handle window in the new tab, method is created and its been called here.
				
				String prodname=driver.findElement(By.xpath(bundle.getString("Random2ndofferxpath"))).getText();
				System.out.println(prodname);
				
				driver.findElement(By.xpath(bundle.getString("Random2ndofferxpath"))).click();
				ABC.flipkart_Newtab();
								
				System.out.println("new tab"+driver.getCurrentUrl());
				
				ABC.flipkart_Text_SizeisPresent();
		}
			
			else
			{
				System.out.println("link gonna be open in same page :"+driver.getCurrentUrl());
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bundle.getString("Random2ndofferxpath")))).click();
				//driver.findElement(By.xpath(bundle.getString("Random2ndofferxpath"))).click();
				
				ABC.flipkart_Filters_dropdown();
				ABC.flipkart_Filters_Brand();
				
				
				ABC.flipkart_Newtab();
				
				ABC.flipkart_Text_SizeisPresent();
			}
		   
		}
		
	}

}





/*public void flipkart_footer()
{
	WebElement footerdriver=driver.findElement(By.xpath(bundle.getString("Footersectionxpath")));
	System.out.println(footerdriver.findElements(By.tagName("a")).size());
	
	for(int z=0;z<2;z++)
{
		
	try
	{
		for(int i=1;i<footerdriver.findElements(By.tagName("a")).size();i++)
		{
			footerdriver.findElements(By.tagName("a")).get(i).getText();
			if(footerdriver.findElements(By.tagName("a")).get(i).getText().contains("Shipping"))
			{
				footerdriver.findElements(By.tagName("a")).get(i).click();
			}
		}
		break;
	}
	    catch(Exception e)
	    {
		    System.out.println(e.getMessage());
	    }
}
	
}*/
