package stepDefinitions;

import cucumber.api.java.en.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.flipkart_createdriver;
import com.flipkart.pages.flipkart_PagetoLoad;
import com.flipkart.pages.flipkart_RandomOffers_common;
import com.flipkart.pages.flipkart_Search;
import com.flipkart.pages.flipkart_assertions;
import com.flipkart.pages.flipkart_homepage;
import com.flipkart.pages.flipkart_login;

import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class FlipkartHomePAGEstepDefinition 
{
	public WebDriver driver;
	flipkart_homepage  FHP;
	
	private ContextSteps contextSteps;
	
	 public FlipkartHomePAGEstepDefinition (ContextSteps contextSteps)
	 {
		 
		 System.out.println("Step def class!"+contextSteps);
		 this.contextSteps = contextSteps;
		 driver=contextSteps.getDriver();
		 FHP=new flipkart_homepage (driver);
		 flipkart_PagetoLoad.waitForLoad(driver,50);
	 }
	 
	 
	    //Flipkart header Menu
	    @Given("^user is on the \"([^\"]*)\" site$")
	    public void user_is_on_the_something_site(String strArg1) 
	    {
	       driver.get(strArg1);
	    }

	    @And("^mousehover on the menu item and click on any of the item$")
	    public void mousehover_on_the_menu_item_and_click_on_any_of_the_item() throws IOException
	    {
	        FHP.flipkart_headerMenu();
	    }
	    
	    @And("^again navigate back to the \"([^\"]*)\" site$")
	    public void again_navigate_back_to_the_something_site(String strArg1)
        {
	    	 driver.get(strArg1);

	    }
	    
	    //Flipkart featured Brand
	    @Then("^Verify the heading text is displayed or not$")
	    public void verify_the_heading_text_is_displayed_or_not() 
	    {
	    	flipkart_assertions.ValidateFeaturebrandtext(driver,"xpath","(//div[@class='_1OuFHs']//h2)[1]");
	    }

	    @And("^click on the feature brand product$")
	    public void click_on_the_feature_brand_product() 
	    {
	        FHP.flipkart_FeatureBrands();
	    }
	    
	    @And("^again back to \"([^\"]*)\" site$")
	    public void again_back_to_something_site(String strArg1)
	    {
	    	driver.get(strArg1);
	    }
	    
	    //flipkart_random offers
	    @And("^click any random offer and add the product in the cart$")
	    public void click_any_random_offer_and_add_the_product_in_the_cart() throws InterruptedException
	    {
	       FHP.flipkart_RandomOffers();
	    }
	 
	
	 
	
	 
	
   

    
}
