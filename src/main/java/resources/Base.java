package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializedriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome
		
		//String browsername = System.getProperty("browser");  //Maven command(System) instead of Properties file browsername  enables us to run Browser as a part of mvn commands
		String browsername = prop.getProperty("browser");
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Selenium/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			
			if(browsername.contains("headless"))
			{
				options.addArguments("--headless");
			}
		    driver=new ChromeDriver(options);
		}
		else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Selenium/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if(browsername.equals("IE")) {
			
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	
	}
	

public String getScrnshot(String TestcaseName,WebDriver driver) throws IOException
{
	/*String store = "./Screenshot/";
	Date d=new Date();
	String d1 = d.toString();
	String d2 = d1.replaceAll(":", "-");*/
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String dst=System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
	org.apache.commons.io.FileUtils.copyFile(src, new File(dst));
	return dst;

}
}
