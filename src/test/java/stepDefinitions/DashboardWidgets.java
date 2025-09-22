package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.LoginPage;
import utility.JsonReader;
import utility.WaitUtils;

public class DashboardWidgets {
	WebDriver driver = Hooks.driver;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	JsonReader jsonReader;
	@Given("I log in to the application")
	public void i_log_in_to_the_application() {
		jsonReader = new JsonReader();
		jsonReader.loadJson("login");
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		
		String user = jsonReader.getVal("login","username");
		String pass = jsonReader.getVal("login","password");
		loginPage.login(user, pass);
	}

	@When("I click {string} widget")
	public void i_click_widget(String widgetName) {
		dashBoardPage.clickWidget(widgetName);
	}

	@Then("I should navigate to Specific webpage and url contains {string}")
	public void i_should_navigate_to_webpage_and_url_contains(String url) {
		WaitUtils.waitForUrlContains(driver, url);
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}
	
}
