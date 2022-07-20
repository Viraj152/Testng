package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Portalhomepage {

	public WebDriver driver;
	By srchbox=By.name("query");
	
	public Portalhomepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement search()
	{
		return driver.findElement(srchbox);
	}
}
