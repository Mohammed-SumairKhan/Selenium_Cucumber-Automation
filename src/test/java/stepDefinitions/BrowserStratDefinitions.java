package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import utility.PropertiesReader;

public class BrowserStratDefinitions {
	WebDriver driver = Hooks.driver;
	PropertiesReader propertiesReader = new PropertiesReader();
	
	@Given("I Open application")
	public void i_open_application() {
		driver.get(propertiesReader.getUrl()); // open the url 
	}
}
