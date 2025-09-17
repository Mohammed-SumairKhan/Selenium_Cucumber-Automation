package stepDefinations;

import org.openqa.selenium.WebDriver;

import driverproperties.BrowserHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.PropertiesReader;

public class Hooks {
	public static WebDriver driver;
	PropertiesReader pr = new PropertiesReader();
	
	@Before
	public void start() {
		driver = BrowserHandler.getBrowser(pr.getBrowserName());
		driver.get(pr.getUrl());
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}
