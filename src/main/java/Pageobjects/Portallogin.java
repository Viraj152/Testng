package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Portallogin {

	public WebDriver driver;
	By un=By.name("email");
	By pwd=By.name("password");
	By but=By.name("commit");
	
	
	public Portallogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement name()
	{
		return driver.findElement(un);
	}
	public WebElement pass()
	{
		return driver.findElement(pwd);
	}
	public WebElement button()
	{
		return driver.findElement(but);
	}
}
