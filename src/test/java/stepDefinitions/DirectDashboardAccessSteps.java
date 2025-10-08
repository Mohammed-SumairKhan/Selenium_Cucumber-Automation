package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Step definitions for the "Direct Dashboard Access Restriction" feature.
 * 
 * This class contains steps to verify that a user cannot access the dashboard
 * directly without logging in.
 */
public class DirectDashboardAccessSteps {

	WebDriver driver = Hooks.driver; // WebDriver instance shared from Hooks class.

	/**
	 * Step definition for opening the browser. This step is executed before
	 * navigating to any URL.
	 */
	@Given("I open the browser")
	public void i_open_the_browser() {
		System.out.println("Browser is opened"); // For demonstration; actual browser is initialized in Hooks
	}

	/**
	 * Step definition to navigate to a specific URL.
	 * 
	 * @param dashBoardUrl The URL to navigate to (e.g., dashboard link)
	 */
	@When("I navigate to {string}")
	public void i_navigate_to(String dashBoardUrl) {
		driver.get(dashBoardUrl); // Navigate to the given URL
	}
}
