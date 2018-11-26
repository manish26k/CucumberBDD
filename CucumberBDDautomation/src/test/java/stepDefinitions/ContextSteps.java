package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextSteps {
	  
	   private static boolean initialized = false;
	   private  static WebDriver driver;
	   
	   @Before
	   public void setUp() throws Exception
	   {
		   System.out.println("Setup Browser!!");
		   
	      if (!initialized)
	      {
	    	  WebDriverManager.chromedriver().setup();
	         driver =  new ChromeDriver();
	         driver.manage().window().maximize();
	         initialized = true;
	         //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	      }
	   }
	   
	   public WebDriver getDriver()
	   {
	      return driver;
	   }
	   
	   @After
	    public void Reporting(Scenario scenario) throws InterruptedException
	    {
		   Screenshot.take_pictureFAILED(scenario, driver);
		   
		   Screenshot.take_picturePASSED(scenario, driver);
		   
		   
		   
		   
	    }
	   
   
	}