package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import Pageobjects.Landingpage;
import Pageobjects.Portalhomepage;
import Pageobjects.Portallogin;
import Pageobjects.Signuppage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

public class stepDefinition extends Base{
	
public String loggingUrl;

@Given("^Initialize browser with chrome$")
public void initialize_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver=initializedriver();
	
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(arg1);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^Click on Login link in home page to land on secure sign in page$")
public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Landingpage la=new Landingpage(driver);
	la.Closeicon().click();
	System.out.println(la.feature().getText());
	la.Reg().click();
	Thread.sleep(2000);
	
}

@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
	Signuppage si=new Signuppage(driver);
	si.login().click();
	Thread.sleep(2000);
	Portallogin po=new Portallogin(driver);
	
	po.name().sendKeys(arg1);
	Thread.sleep(2000);
	po.pass().sendKeys(arg2);
	Thread.sleep(2000);
	po.button().click();
	Thread.sleep(2000);
}

@Then("^Verify that the user is successfully logged in$")
public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
   
	
	Portalhomepage po=new Portalhomepage(driver);
	Assert.assertTrue(po.search().isDisplayed());	
}

@And("^close Browsers$")
public void close_browsers() throws Throwable {
    driver.quit();
}



}
