package stepDefinitions;

import cucumber.api.java.en.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.flipkart_createdriver;
import com.flipkart.pages.flipkart_Cart;
import com.flipkart.pages.flipkart_PagetoLoad;
import com.flipkart.pages.flipkart_RandomOffers_common;
import com.flipkart.pages.flipkart_Search;
import com.flipkart.pages.flipkart_assertions;
import com.flipkart.pages.flipkart_login;

import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class FlipkartCartstepDefinition 
{
	public WebDriver driver;
	flipkart_Cart FC;
	
	private ContextSteps contextSteps;
	
	 public FlipkartCartstepDefinition (ContextSteps contextSteps)
	 {
		 
		 System.out.println("Step def class!"+contextSteps);
		 this.contextSteps = contextSteps;
		 driver=contextSteps.getDriver();
		 FC=new flipkart_Cart(driver);
		 flipkart_PagetoLoad.waitForLoad(driver,50);
	   }
	 
	
	 
	    @And("^verify the cart quantity$")
	    public void verify_the_cart_quantity() throws InterruptedException, IOException
	    {
	        FC.flipkart_cartQunatity();
	    }

	    @And("^displayed product name present in the cart$")
	    public void displayed_product_name_present_in_the_cart() 
	    {
	        FC.fullcartProductname();
	    }
	 
	
   

    
}
