package com.flipkart.pages;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flipkart_Search
{
	WebDriver driver;
	ResourceBundle bundle;
	Actions action;
	WebDriverWait wait;
	
	
// Constructor
	public flipkart_Search(WebDriver driver)
	{
		this.driver=driver;
		bundle=ResourceBundle.getBundle("Element");
		action= new Actions(driver);
		//this.wait= new WebDriverWait(driver,5000); 
	}
	
	//public void flipkart_Search_prod(String name) throws InterruptedException
	//{
		/*for (int z=0;z<2;z++)
		{
			try
			{
				driver.findElement(By.xpath(bundle.getString("Searchtextfieldxpath"))).sendKeys(name);
				//click on the Search icon button
				driver.findElement(By.xpath(bundle.getString("Searchiconbuttonxpath"))).click();
				
				flipkart_RandomOffers_common ABC= new flipkart_RandomOffers_common(driver);
				
				
						ABC.flipkart_Filters();
						ABC.flipkart_Newtab();
						ABC.flipkart_Text_SizeisPresent();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}*/
		
		
		
	
	/*After entering the text in Search text box then the autosuggestion is displayed.
	Select from any text from the Autosuggestion and click that text*/
	
	
	
	public void selectOptionWithText(String textToSelect) throws InterruptedException
	{
		    flipkart_PagetoLoad.waitForLoad(driver,50);
		
		    driver.findElement(By.xpath(bundle.getString("Searchtextfieldxpath"))).sendKeys("mobile");
		    
			
			Thread.sleep(1000);
			
			List<WebElement> list= driver.findElements(By.xpath(bundle.getString("SearchautoOptionbytagxpath")));
			
			
			
			System.out.println("total number of suggestions in search box------" + list.size() );
			
			for(int i=0; i<list.size(); i++)
			{
				System.out.println(list.get(i).getText());
				
				if(list.get(i).getText().contains(textToSelect))
				{
                       list.get(i).click();
                       break;
 				}
		  }
			
			flipkart_RandomOffers_common ABC= new flipkart_RandomOffers_common(driver);
	    		
	    		
	    		/*ABC.flipkart_Filters_dropdown();
	    		ABC.flipkart_Filters_Brand();
	    		
	    		
	    		ABC.flipkart_Newtab();
	    		ABC.flipkart_Text_SizeisPresent();*/
	    		
	
	    
	}
	
	
	
	
	/*Case01- when we mouse over on any element then tooltip text is displayed and when we inspect it sometimes tooltip text
	        displayed in the "Title" attribute,which is written below.*/
	
	
	
	public void searchTooltoptext(String locator )
	{
		
		flipkart_PagetoLoad.waitForLoad(driver,50);
		
		String toolTipText= driver.findElement(By.cssSelector(bundle.getString(locator))).getAttribute("title");
		
		System.out.println("Tool tip text present :- " + toolTipText);
		
	}
	
	
	
	
	/*Case02- when we mouse over on any element then sometimes tooltip text is displayed but it's not under "Title" attribute.
	        when ever we mouse over on the element ,then some "tag" is generated and tooltip text is displayed
	        In such cases we need to perform "Action" Class show below.
	        
	
	public void toolTipCase2() {
		driver.navigate().to("https://jqueryui.com/tooltip/");

		// As there is frame, we have to navigate to frame
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));

		// Text box field, where we mouse hover
		WebElement element = driver.findElement(By.id("age"));

		// Use action class to mouse hover on Text box field
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));

		// To get the tool tip text and assert
		String toolTipText = toolTipElement.getText();
		Assert.assertEquals("We ask for your age only for statistical purposes.", toolTipText);

	}*/
	      
	      
	      
	
}
