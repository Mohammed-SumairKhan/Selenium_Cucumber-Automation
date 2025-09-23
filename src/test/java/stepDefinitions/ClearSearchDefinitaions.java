package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class ClearSearchDefinitaions {
	SearchPage searchPage = new SearchPage(Hooks.driver);

	@Given("I have entered {string} in the search bar")
	public void i_have_entered_in_the_search_bar(String searchText) {
		searchPage.searchBy(searchText);
	}

	@When("I click the clear search button")
	public void i_click_the_button() {
		searchPage.clickClearSearch();
	}

	@Then("the search bar should be empty")
	public void the_search_bar_should_be_empty() {
		Assert.assertTrue(searchPage.isSearchBarEmpty());
	}
}
