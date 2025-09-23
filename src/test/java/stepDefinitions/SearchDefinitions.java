package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SearchPage;
import utility.JsonReader;

public class SearchDefinitions {
	WebDriver driver = Hooks.driver;
	SearchPage searchPage;
	LoginPage loginPage;
	JsonReader jsonReader;

	public SearchDefinitions() {
		driver = Hooks.driver;
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		jsonReader = new JsonReader();
		jsonReader.loadJson("login");
	}

	@Given("I Login in the application")
	public void i_login_in_the_application() {
		String user = jsonReader.getVal("login", "username");
		String pass = jsonReader.getVal("login", "password");

		loginPage.login(user, pass);
	}

	@When("I search with {string}")
	public void i_search_with(String text) {
		searchPage.searchBy(text);
	}

	@Then("I check for expected results contains {string}")
	public void i_check_for_expected_results(String expectedResult) {
		Assert.assertTrue(searchPage.isResultDisplayed(expectedResult), "Expected result not found: " + expectedResult);
	}

}
