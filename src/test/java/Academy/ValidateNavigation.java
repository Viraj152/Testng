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

public class ValidateNavigation extends Base {
	public WebDriver driver;
    public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializedriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	}
	
	@Test
	public void asserttxt() throws IOException
	{
		///Thread.sleep(6000);
		Landingpage la=new Landingpage(driver);	
		/*In order to compare actual and expected result we use assertion and it'll throw error when 
		 * there's discrepency*/
		Assert.assertTrue(la.NavBar().isDisplayed()); //If the condition specified within parenthesis fails,@test fails	
		log.info("Navigation Bar is Displayed");
		System.out.println("Test Completed");
		Assert.assertFalse(false); //intentionally failing the test case
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
