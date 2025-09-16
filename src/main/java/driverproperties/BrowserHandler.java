package driverproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHandler {
	
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		switch(browserName) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
		default:
			System.out.println("Browser Not Supported");
		}
		driver.manage().window().maximize();
		return driver;
	}
}
