package stepDefinitions;

import org.openqa.selenium.WebDriver;

import driverproperties.BrowserHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.PropertiesReader;
import utility.WaitUtils;

public class Hooks {
	public static WebDriver driver;
	PropertiesReader pr = new PropertiesReader();
	
	@Before
	public void start() {
		driver = BrowserHandler.getBrowser(pr.getBrowserName());
		WaitUtils.implicitWait(driver);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}
