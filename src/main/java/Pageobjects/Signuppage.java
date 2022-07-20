package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signuppage {

	public WebDriver driver;
	
	By log=By.xpath("//a[.='Login']");
	
	
	public Signuppage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement login()
	{
		return driver.findElement(log);
	}
	
	
}
