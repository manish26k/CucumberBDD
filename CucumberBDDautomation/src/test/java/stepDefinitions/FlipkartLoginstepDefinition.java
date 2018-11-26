package stepDefinitions;

import cucumber.api.java.en.*;



import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.base.flipkart_createdriver;
import com.flipkart.pages.flipkart_PagetoLoad;
import com.flipkart.pages.flipkart_assertions;
import com.flipkart.pages.flipkart_login;

import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class FlipkartLoginstepDefinition   
{
	public WebDriver driver;
	
	flipkart_login FL;

	private ContextSteps contextSteps;
	
	 public FlipkartLoginstepDefinition (ContextSteps contextSteps)
	 {
	      System.out.println("Step def class!"+contextSteps);
		 this.contextSteps = contextSteps;
		 driver=contextSteps.getDriver();
		 flipkart_PagetoLoad.waitForLoad(driver,50);
	  }
	 
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() 
	{
		
		driver= contextSteps.getDriver();
    }
 	
	@And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) 
	{
		driver.get(strArg1);
    }

    @When("^User enters (.+) and (.+) and login$")
    public void user_enters_and_and_login(String username, String password)
    {
    	FL= new flipkart_login(driver);
    	FL.flipkart_login_username(username);
    	FL.flipkart_login_password(password);
    	FL.flipkart_login_clickbutton();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() 
    
    {
    	System.out.println("Verifying login!!"+driver);
    	Assert.assertTrue(flipkart_assertions.Validatepagetitle(driver, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Exclusive Offers!"));
    }
    
   

    
}
