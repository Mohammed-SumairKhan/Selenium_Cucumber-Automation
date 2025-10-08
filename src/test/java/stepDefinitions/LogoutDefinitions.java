package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utility.JsonReader;
import utility.WaitUtils;

public class LogoutDefinitions {
	WebDriver driver = Hooks.driver;
	LoginPage loginPage;
	JsonReader jsonReader = new JsonReader();
	
	@Given("I logged in to the application")
	public void i_logged_in_to_the_application() {
	   loginPage = new LoginPage(driver);
	   jsonReader.loadJson("login");
	   
	   String userName = jsonReader.getVal("login","username");
	   String password = jsonReader.getVal("login","password");
	   
	   loginPage.login(userName, password);
	}

	@When("I click the Logout button")
	public void i_clicks_the_button() {
	    loginPage.clickLogoutButton(); // clicks the logout button
	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page() {
		WaitUtils.waitForUrlContains(driver, "login");
	    Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
	
	@When("I click the admin drop down")
	public void i_click_the_admin_drop_down() {
	    loginPage.clickDropDown();
	}

	@And("I click Logout link")
	public void i_clicks_link() {
	  loginPage.clickLogoutLink();
	}

	

}
