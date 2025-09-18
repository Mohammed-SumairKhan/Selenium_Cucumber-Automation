package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverproperties.BrowserHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utility.PropertiesReader;
import utility.WaitUtils;

public class LoginStepDefinations {
	WebDriver driver;
	PropertiesReader pr = new PropertiesReader();
	LoginPage lp;
	@Given("I Lunch Chrome Browser")
	public void i_lunch_chrome_browser() {
	    driver = BrowserHandler.getBrowser(pr.getBrowserName());
	    WaitUtils.implicitWait(driver);
	    lp = new LoginPage(driver);
	}

	@When("I Opens URL")
	public void i_opens_url() {
	    driver.get(pr.getUrl());
	}

	@When("I Enter Email as {string} and Password  as {string}")
	public void i_enter_email_as_and_password_as(String email, String password) {
	    lp.login(email, password);
	}

	@When("Click on Login")
	public void click_on_login() {
	    System.out.println("suceesfull logged in");
	}

	@Then("Page Url Conatins {string}")
	public void page_url_conatins(String url) {
	   WaitUtils.waitForUrlContains(driver, url);
	   Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	@Then("Close Browser")
	public void close_browser() {
	   driver.close();
	}
}
