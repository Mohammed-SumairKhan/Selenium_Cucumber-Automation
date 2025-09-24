package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class represents the Navigation Menu Page in the application. It
 * contains locators for menu items such as New Leads, All Leads, Customers,
 * etc. and provides action methods to navigate to the corresponding pages.
 */
public class NavigationMenuPage {
	WebDriver driver;

	/** Locator for 'New Leads' navigation link */
	@FindBy(linkText = "New Leads")
	WebElement newLeads;

	/** Locator for 'All Leads' navigation link */
	@FindBy(linkText = "All Leads")
	WebElement allLeads;

	/** Locator for 'Customer' navigation link */
	@FindBy(linkText = "Customer")
	WebElement customer;

	/** Locator for 'Add Services' navigation link */
	@FindBy(linkText = "Add Services")
	WebElement addServices;

	/** Locator for 'Add Employee' navigation link */
	@FindBy(linkText = "Add Employee")
	WebElement addEmployee;

	/** Locator for 'Add Task' navigation link */
	@FindBy(linkText = "Add Task")
	WebElement addTask;

	/**
	 * Constructor to initialize the NavigationMenuPage.
	 * 
	 * @param driver The WebDriver instance used to interact with the browser.
	 */
	public NavigationMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks the given navigation link
	 * @param name Name of the navigation link
	 */
	public void click(String name) {
		try {
			switch (name.toLowerCase()) {
			case "new leads":
				newLeads.click();
				break;
			case "all leads":
				allLeads.click();
				break;
			case "customer":
				customer.click();
				break;
			case "add services":
				addServices.click();
				break;
			case "add employee":
				addEmployee.click();
				break;
			case "add task":
				addTask.click();
				break;
			default:
				System.out.println("Given Navigation link is not available");

			}
		} catch (Exception e) {
			throw new RuntimeException("Cann't click the navigation: " +name + e);
		}
	}
}
