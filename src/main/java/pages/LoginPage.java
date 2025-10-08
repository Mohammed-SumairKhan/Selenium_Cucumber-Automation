package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// Locator for username input field
	@FindBy(name = "username")
	WebElement usernameInput;

	// Locator for password input field
	@FindBy(name = "password")
	WebElement passwordInput;

	// Locator for login button
	@FindBy(className = "btn-login")
	WebElement loginButton;

	// Locator for logout button
	@FindBy(xpath = "//*[@class= 'logout-btn']")
	WebElement logoutButton;
	
	// Locator for drop down
	@FindBy(xpath = "//div[@class = 'user-dropdown']")
	WebElement userDropDown;
	
	// Locator for logout link
	@FindBy(xpath = "//button[@class='dropdown-item d-flex align-items-center']")
	WebElement logoutLink;
	
	/**
	 * Constructor to initialize the LoginPage object. Initializes the web elements
	 * using PageFactory.
	 * 
	 * @param driver WebDriver instance passed from the test class
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Perform login with valid credentials. Enters the username and password, then
	 * clicks the login button.
	 * 
	 * @param user The username to login
	 * @param pass The password to login
	 */
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		try {
		logoutButton.click();
		} catch(Exception e) {
			throw new RuntimeException("Cann't click Logout Button" + e);
		}
	}
	
	public void clickDropDown() {
		try {
		userDropDown.click();
		} catch(Exception e) {
			throw new RuntimeException("Cann't click Logout Button" + e);
		}
	}
	
	public void clickLogoutLink() {
		try {
		logoutLink.click();
		} catch(Exception e) {
			throw new RuntimeException("Cann't click Logout Button" + e);
		}
	}
	
}
