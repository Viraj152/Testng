package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPass {

	public WebDriver driver;
	
	By email=By.cssSelector("input[id='user_email']");
	By Instrn=By.cssSelector("input[name='commit']");

	
	public ForgotPass(WebDriver driver) {
		this.driver=driver;
	}

	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getInstruction()
	{
		return driver.findElement(Instrn);
	}
	
	
}
	