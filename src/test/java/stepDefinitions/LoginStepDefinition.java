package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utility.PropertiesReader;
import utility.WaitUtils;

public class LoginStepDefinition {
	WebDriver driver = Hooks.driver;
	PropertiesReader pr = new PropertiesReader();
	LoginPage loginPage = new LoginPage(driver);

@Given("I enter the email {string} and password {string}")
public void i_enter_the_email_and_password(String userName, String password) {
    loginPage.login(userName, password);
}

@Given("I click on Login")
public void i_click_on_login() {
    System.out.println("clicked login");
}

@Then("Page URL contains {string}")
public void page_url_contains(String url) {
   WaitUtils.waitForUrlContains(driver, url);
   Assert.assertTrue(driver.getCurrentUrl().contains(url));
}

@Given("I enter Email as {string} and Password as {string}")
public void i_enter_email_as_and_password_as(String userName, String password) {
    loginPage.login(userName, password);
}

}
