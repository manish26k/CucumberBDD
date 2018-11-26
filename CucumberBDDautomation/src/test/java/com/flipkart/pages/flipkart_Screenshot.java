package com.flipkart.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.flipkart_createdriver;

public class flipkart_Screenshot 
{
	public static ChromeDriver driver; 
		/*public static void takeSnapShot(WebDriver driver, String screenshotName) throws IOException
		{
			
			System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
						
				try
				{
			
				File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				
				File destfile= new File("./Screenshots/"+screenshotName+" "+timestamp()+".png");
				
				//File destfile= new File("./Screenshots/"+screenshotName+".png");
				
				FileUtils.copyFile(scrfile,destfile);
				}
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		
		
		
		public static String timestamp()
		{
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}*/
	
	
	
	public static void takeSnapShot(String result) throws IOException
	{
		
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
					
			try
			{
		
			File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			
			File destfile= new File("./Screenshots/"+result+timestamp()+".png");
			
			//File destfile= new File("./Screenshots/"+screenshotName+".png");
			
			FileUtils.copyFile(scrfile,destfile);
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	
	
	
	public static String timestamp()
	{
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
