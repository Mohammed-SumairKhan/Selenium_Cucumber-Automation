package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SearchPage;
import utility.JsonReader;
import utility.WaitUtils;

public class SearchDefinations {
	WebDriver driver = Hooks.driver;
	SearchPage searchPage;
	LoginPage loginPage;
	JsonReader jsonReader;
	@Given("I Login in the application")
	public void i_login_in_the_application() {
		jsonReader = new JsonReader();
		jsonReader.loadJson("login");
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		String user = jsonReader.getVal("login","username");
		String pass = jsonReader.getVal("login","password");

		System.out.println("User from JSON = " + user);
		System.out.println("Pass from JSON = " + pass);

		loginPage.login(user, pass);
	}

	@When("I search with {string}")
	public void i_search_with(String string) {
		searchPage.searchByName(string);
	}

	@Then("I check for expected results contains {string}")
	public void i_check_for_expected_results(String string) {
	    WaitUtils.applyHardWait(); // Allow results to load
	    WebElement result = driver.findElement(By.xpath("//strong[text()='" + string + "']")); // Locate search result
	    WaitUtils.waitForElementVisible(driver, result); // Wait until result is visible
	    String actual_name = result.getText(); // Capture actual name
	    String expected_name = string; // Expected name
	    Assert.assertEquals(actual_name, expected_name); // Verify search result
	}


}
