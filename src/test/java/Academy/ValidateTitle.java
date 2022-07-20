package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.Landingpage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	Landingpage la;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializedriver();
		log.info("Driver is Initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to the Home Page");
	}
	
	@Test
	public void asserttxt() throws IOException
	{	
		///Thread.sleep(6000);
		la=new Landingpage(driver);	
		/*In order t compare actual and expected result we use assertion and it'll throw error when 
		 * there's discrepency*/
		Assert.assertEquals(la.feature().getText(), "FEATURED COURSES");	
		log.info("Successfully validated the text message");
	}
	
	@Test
	public void validateHeader() throws IOException
	{	
		///Thread.sleep(6000);
		la=new Landingpage(driver);	
		/*In order t compare actual and expected result we use assertion and it'll throw error when 
		 * there's discrepency*/
		Assert.assertEquals(la.head().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");	
		log.info("Successfully validated the text message");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
