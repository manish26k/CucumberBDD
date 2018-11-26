package com.flipkart.testcases;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flipkart.base.flipkart_createdriver;
import com.flipkart.pages.flipkart_Cart;
import com.flipkart.pages.flipkart_Search;
import com.flipkart.pages.flipkart_assertions;
import com.flipkart.pages.flipkart_homepage;
import com.flipkart.pages.flipkart_login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart_TestCases 

{
	public WebDriver driver;
	public ResourceBundle rb;
	public WebDriverWait wait;
	
	boolean result;
	SoftAssert softAssert= new SoftAssert();
	
	public ResourceBundle bundle;
	
	@BeforeClass
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
	
	
	@Test(priority=0, description="Flipkart Login Test Case")
	public void flipkart_Login(String username, String password)
	{
		System.out.println("DEBUG: Login fucntion!!");

		flipkart_login FL= new flipkart_login(driver);
        /*FL.flipkart_login();*/
		FL.flipkart_login_username(username);
		FL.flipkart_login_password(password);
		FL.flipkart_login_clickbutton();
	}
	
	
	
	@Test(priority=2,description="Flipkart Search Test Case")
	public void flipkart_Search() throws InterruptedException
	{
		//driver.get(rb.getString("URL"));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(bundle.getString("Searchtextboxcss"))));
		
		flipkart_Search FS= new flipkart_Search(driver);
        //FS.flipkart_Search_prod("Mobile");
		
		FS.searchTooltoptext("searchToolTipcss");
        FS.selectOptionWithText("mobile watch");
		
	
		/*for(int k=0;k<2;k++)
		{
			try
			{
				FS.searchTooltoptext("searchToolTipcss");
		        FS.selectOptionWithText("mobile watch");	
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}*/
        
	}
	
	@Test(dependsOnMethods = {"flipkart_Login"},alwaysRun=true, description="Flipkart HomePage Test Case")
	public void flipkart_homepage () throws IOException, InterruptedException
	{
		
		result=flipkart_assertions.Validatepagetitle(driver, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More");
	    softAssert.assertTrue(result, "[message- HomePage title didn't get matched]");
		
		
		flipkart_homepage FH= new flipkart_homepage(driver);
		
		
		FH.flipkart_headerMenu();
		
		//here validating that feature brand heading text is displayed or not
        result=flipkart_assertions.ValidateFeaturebrandtext(driver, "xpath", "//div[@class='_1OuFHs']//h2");
        softAssert.assertTrue(result, "[message- feature Brand heading title text is not displayed]");
				
		FH.flipkart_FeatureBrands();
		
		
		driver.get(rb.getString("URL"));
		
		
		//here validating weather the random2prod is displayed or not.
        result=flipkart_assertions.ValidateRandom2ndprod(driver, "xpath","(//div[@class='_1GRhLX _3JslKL required-tracking'][3]//div[2]//a)[2]");
        softAssert.assertTrue(result, "[message- Random2prod is not present]");
		
		FH.flipkart_RandomOffers();
		
		
		softAssert.assertAll();
	}
	
	@Test(priority=3, description="Flipkart Cart Page Test Case" )
	public void flipkart_cartPage() throws InterruptedException, IOException
	{
		driver.get(rb.getString("URL"));
        flipkart_Cart FC= new flipkart_Cart(driver);
        FC.flipkart_cartQunatity();
        FC.fullcartProductname();
        
        
        //here validating the product is added in the cart by getting the text fron the cart.
        result=flipkart_assertions.ValidatePRODaddedinCART(driver, "xpath","(//a[@class='_325-ji _3ROAwx'])[1]");
        softAssert.assertTrue(result, "[message- Product is not added into the Cart]");
        
        softAssert.assertAll();
	}
	
	
	

}