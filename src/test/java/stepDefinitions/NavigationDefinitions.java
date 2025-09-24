package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.NavigationMenuPage;
import utility.JsonReader;
import utility.WaitUtils;

public class NavigationDefinitions {
	WebDriver driver = Hooks.driver;
	JsonReader jsonReader;
	LoginPage loginPage;
	NavigationMenuPage navigationMenuPage;
	@Given("I am logged into the application")
	public void i_am_logged_into_the_application() {
		loginPage = new LoginPage(driver);
		jsonReader = new JsonReader();
		jsonReader.loadJson("login");
		navigationMenuPage = new NavigationMenuPage(driver);
		
		String userName = jsonReader.getVal("login", "username");
		String password = jsonReader.getVal("login", "password");
		
		loginPage.login(userName, password);
	}

	@When("I click {string}")
	public void i_click(String string) {
		navigationMenuPage.click(string);
	}

	@Then("I will navigate to the correct webpage {string}")
	public void i_will_navigate_to_the_correct_webpage(String url) {
		WaitUtils.waitForUrlContains(driver, url);
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

}
