package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtils;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id = "username")
	@CacheLookup
	WebElement emailInput;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement passwordInput;
	
	@FindBy(xpath = "//button[@class = 'btn btn-login']")
	@CacheLookup
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}
	
	public void setPassword(String password) {
		WaitUtils.waitForElementVisible(driver, passwordInput);
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		WaitUtils.waitForElementClickable(driver, loginButton);
		loginButton.click();
	}
	
}
