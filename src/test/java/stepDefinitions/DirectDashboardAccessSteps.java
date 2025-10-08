package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DirectDashboardAccessSteps {
	WebDriver driver = Hooks.driver;

	@Given("I open the browser")
	public void i_open_the_browser() {
		System.out.println("Browser is opened");
	}

	@When("I navigate to {string}")
	public void i_navigate_to(String dashBoardUrl) {
		driver.get(dashBoardUrl);
	}
}
