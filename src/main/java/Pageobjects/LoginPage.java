package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email=By.id("user_email");
	By pwd=By.name(" password");
	By Go=By.name("commit");
	By Forgot=By.xpath("//a[.='Forgot Password?']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement forgpwd()
	{
		return driver.findElement(Forgot); //Since after Clicking on 'Forgot Password' we'll navigate to a new page.

	}
	public WebElement getUN()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPWD()
	{
		return driver.findElement(pwd);
	}
	public WebElement login()
	{
		return driver.findElement(Go);
	}
}
	