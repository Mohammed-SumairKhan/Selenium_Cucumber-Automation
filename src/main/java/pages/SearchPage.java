package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtils;

/**
 * SearchPage class represents the search functionality of the application. It
 * contains web elements and methods to perform searches by different criteria
 * and to clear the search results.
 * 
 * Uses PageFactory to initialize web elements.
 */
public class SearchPage {
	WebDriver driver;

	// Locator for searchBar
	@FindBy(name = "search")
	WebElement searchBar;

	// Locator for searchButton
	@FindBy(css = "button.search-btn")
	WebElement searchButton;

	// Locator for clearSearchButton
	@FindBy(xpath = "//a[contains(@class , 'clear-search')]")
	WebElement clearSearchButton;
	
	// locator for searchResults
	@FindBy(xpath = "//strong")
	WebElement searchResults;
	/**
	 * Constructor to initialize the SearchPage object. Initializes the web elements
	 * using PageFactory.
	 * 
	 * @param driver WebDriver instance passed from the test class
	 */
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * search based on the given searchText and 
	 * click search button
	 * @param searchText
	 */
	public void searchBy(String searchText) {
		try {
		searchBar.clear(); // clear is there is any text in search bar
		searchBar.sendKeys(searchText); // send the searchText 
		WaitUtils.waitForElementClickable(driver, searchButton);
		searchButton.click(); // clicks the search button 
		} catch(Exception e) {
			throw new RuntimeException("Failed to perform test: " + searchText + e);
			
		}
	}
	
	/**
	 *  return true is the result contains the exp_res
	 *  else false
	 * @param expectedText
	 * @return
	 */
	public boolean isResultDisplayed(String expectedText) {
	   return WaitUtils.isTextPresent(driver, searchResults, expectedText);
	}
	
	/**
	 * Clicks on the Clear Search button to reset the search input and results.
	 */
	public void clickClearSearch() {
		try {
			WaitUtils.waitForElementClickable(driver, clearSearchButton);
			clearSearchButton.click(); // click clear search button
		} catch (Exception e) {
			throw new RuntimeException("Failed to click clear search button: "+ e);
		}
	}
	/**
	 * check is the search bar is empty or not after clicking the clear search button 
	 * and return true if it is empty else false
	 * @return
	 */
	public boolean isSearchBarEmpty() {
		return searchBar.getAttribute("value").isEmpty();
	}
}
