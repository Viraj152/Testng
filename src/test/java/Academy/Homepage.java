package Academy;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.ForgotPass;
import Pageobjects.Landingpage;
import Pageobjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	Landingpage la=null;
	LoginPage lo=null;
	String loginURL;

	
	
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializedriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		la=new Landingpage(driver);
		//Actions act= new Actions(driver);
		//act.moveToElement(driver.findElement(la.close)).click().perform();
	   // la.Closeicon().click();
	    System.out.println(la.feature().getText());
		Thread.sleep(2000);
		la.getLogin().click();	
	}
	
	@Test(dataProvider="getData")
	public void basepagenavigate(String user,String pass,String text) throws InterruptedException 
	{
		
		String loggingUrl = driver.getCurrentUrl();
		lo=new LoginPage(driver);
		lo.getUN().sendKeys(user);
		Thread.sleep(2000);
		lo.getPWD().sendKeys(pass);
		Thread.sleep(2000);
		lo.login().click();	
		Thread.sleep(2000);
		log.info(text);
		String loggedUrl = driver.getCurrentUrl();
		if (loggingUrl.equals(loggedUrl)) {
			System.out.println("Invalid Credentials");
		} else {
			System.out.println("Valid Credentials");
		}
		driver.navigate().refresh();

	}
	
	@AfterTest
	public void close() throws InterruptedException
	{
		lo=new LoginPage(driver);
		Thread.sleep(2000);
		lo.forgpwd().click();
		ForgotPass fp=new ForgotPass(driver);
		fp.getemail().sendKeys("jasgfm");
		Thread.sleep(2000);
		fp.getInstruction().click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row represent sets of data
		//Coloumn indicates How many values for each set
		Object[][] det=new Object[2][3];
		//0th row data
		det[0][0]="vervfh";
		det[0][1]="hf";
		det[0][2]="Invalid Credentials";

		//1st Row
		det[1][0]="jhfk";
		det[1][1]="92836";
		det[1][2]="Invalid Credentials";

		
		return det;
		
	}
	
	
}
