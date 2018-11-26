package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;


import cucumber.api.Scenario;

public class Screenshot
{
	
	private ContextSteps contextSteps;
	
	 public Screenshot (ContextSteps contextSteps)
	 {
	      this.contextSteps = contextSteps;
	 }

	/*public static void take_pictureFAILED(Scenario scenario,WebDriver driver) throws InterruptedException
	{
		if(scenario.isFailed())
		{
			Thread.sleep(2000);
			scenario.write("Failed Screenshot");
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
		}
		
		return;
	}*/
	 
	 public static void take_pictureFAILED(Scenario scenario,WebDriver driver) throws InterruptedException
		{
			if(scenario.isFailed())
			{
				Thread.sleep(2000);
				scenario.write("Failed Screenshot");
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				try
				{
			
				      File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								
				      File destfile= new File("/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				      
			          FileUtils.copyFile(scrfile,destfile);
			          
			          Reporter.addScreenCaptureFromPath(destfile.toString());
				}
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			
			return;
				
		}
			
			
		
	
	/*public static void take_picturePASSED(Scenario scenario,WebDriver driver) throws InterruptedException
	{
		if(!(scenario.isFailed()))
		{
			Thread.sleep(2000);
			scenario.write("Passed Screenshot");
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
		}
		
		return;
	}*/
	 
	 public static void take_picturePASSED(Scenario scenario,WebDriver driver) throws InterruptedException
		{
			if(!(scenario.isFailed()))
			{
				Thread.sleep(2000);
				scenario.write("Passed Screenshot");
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				try
				{
			
				      File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								
				      File destfile= new File("/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				      
			          FileUtils.copyFile(scrfile,destfile);
			          
			          Reporter.addScreenCaptureFromPath(destfile.toString());
				}
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			
			return;
				
		}
	
	
	
	
	
	
}
