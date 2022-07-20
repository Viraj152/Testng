package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	public WebDriver driver;
	
	private By login=By.xpath("//span[.='Login']");
	private By close=By.xpath("//button[text()='NO THANKS']");
	private By Text=By.xpath("//h2[.='Featured Courses']");
	private By Courses=By.xpath("//a[.='Contact']");
	private By navigation=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By Register=By.xpath("//span[.='Register']");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement Closeicon()
	{
		return driver.findElement(close);
	}
	
	public WebElement feature()
	{
		return driver.findElement(Text);
	}
	public WebElement Course()
	{
		return driver.findElement(Courses);
	}
	public WebElement NavBar()
	{
		return driver.findElement(navigation);
	}
	public WebElement Reg()
	{
		return driver.findElement(Register);
	}
	public WebElement head()
	{
		return driver.findElement(header);
	}
	
}
	