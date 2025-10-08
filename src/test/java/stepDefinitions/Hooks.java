package stepDefinitions;

import org.openqa.selenium.WebDriver;

import driverproperties.BrowserHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.PropertiesReader;
import utility.WaitUtils;

/**
 * Hooks class contains setup and teardown methods for Cucumber tests.
 * It initializes the WebDriver before each scenario and closes it after each scenario.
 */
public class Hooks {

    public static WebDriver driver; //WebDriver instance shared across step definitions.
    PropertiesReader pr = new PropertiesReader(); //PropertiesReader instance to read configuration like browser type.

    /**
     * @Before hook runs before each scenario.
     * It initializes the WebDriver using the browser specified in properties
     * and sets implicit wait for element loading.
     */
    @Before
    public void start() {
        driver = BrowserHandler.getBrowser(pr.getBrowserName()); // Initialize browser
        WaitUtils.implicitWait(driver); // Apply implicit wait
    }

    /**
     * @After hook runs after each scenario.
     * It quits the WebDriver instance to close all browser windows
     * and end the session cleanly.
     */
    @After
    public void tearDown() {
        driver.quit(); // Close browser and terminate WebDriver session
    }
}
