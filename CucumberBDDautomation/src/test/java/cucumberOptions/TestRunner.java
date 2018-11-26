package cucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(
		features= "src\\test\\java\\features\\",
		glue={"stepDefinitions"},

		//plugin= {"pretty","html:target/Destination"},
		//plugin= {"pretty","json:target/cucumber-reports/Cucumber.json"},
		//plugin= {"pretty","junit:target/cucumber-reports/Cucumber.xml"},
		//plugin={ "usage","html:target/Destination" },
		/*plugin = { "pretty","usage", "json:target/cucumber-reports/Cucumber.json",
						"junit:target/cucumber-reports/Cucumber.xml",
						"html:target/cucumber-reports"},*/
		
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		//plugin="html:target/selenium-reports",
		
		
		
		monochrome= true
		)




public class TestRunner extends AbstractTestNGCucumberTests 
{
	@AfterClass
	public static void writeExtentReport()
	{
		
		Reporter.loadXMLConfig(new File("src/test/java/features/extent-config.xml"));
	}
	
}
