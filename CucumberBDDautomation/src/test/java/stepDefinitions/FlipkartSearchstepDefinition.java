package stepDefinitions;

import cucumber.api.java.en.*;



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
import com.flipkart.pages.flipkart_login;

import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class FlipkartSearchstepDefinition 
{
	public WebDriver driver;
	flipkart_Search FS;
	
	private ContextSteps contextSteps;
	
	 public FlipkartSearchstepDefinition (ContextSteps contextSteps)
	 {
		 
		 System.out.println("Step def class!"+contextSteps);
		 this.contextSteps = contextSteps;
		 driver=contextSteps.getDriver();
		 FS=new flipkart_Search(driver);
		 flipkart_PagetoLoad.waitForLoad(driver,50);
	   }
	 
	
	 
	 @Then("^Verify tool tip text from search box$")
    public void verify_tool_tip_text_from_search_box()
	{ 
				
		/*flipkart_PagetoLoad.waitForLoad(driver, 30);*/
		
		FS.searchTooltoptext("searchToolTipcss");
    }
	 
	 @When("^enter text in the search box then select randomly from the suggestion list$")
	    public void enter_text_in_the_search_box_then_select_randomly_from_the_suggestion_list() throws InterruptedException
	 {
			 
		 FS.selectOptionWithText("mobile watch");	 
	 }
	 
	 @Then("^Verify Price is displayed and select the price from dropdown$")
	    public void verify_price_is_displayed_and_select_the_price_from_dropdown() throws InterruptedException 
	    {
		    flipkart_RandomOffers_common.flipkart_Filters_dropdown();
	    }

	    @And("^Verify Brand is displayed checkbox selected and click on the product$")
	    public void verify_brand_is_displayed_checkbox_selected_and_click_on_the_product() throws InterruptedException 
	    {
	    	flipkart_RandomOffers_common.flipkart_Filters_Brand();
	    	
	    }
	    
	    @And("^if link open in the new tab$")
	    public void if_link_open_in_the_new_tab() 
	    {
	    	flipkart_RandomOffers_common.flipkart_Newtab();
	    }
  	    
	    @And("^check Size is present and click on addtocart or else click addtocart only$")
	    public void check_size_is_present_and_click_on_addtocart_or_else_click_addtocart_only() throws InterruptedException
	    {
	    	flipkart_RandomOffers_common.flipkart_Text_SizeisPresent();  
	    }
	    
	    @And("^again user navigate to the \"([^\"]*)\" site$")
	    public void again_user_navigate_to_the_something_site(String strArg1)
	    {
	        driver.get(strArg1);
	    }
	 
	
   

    
}
