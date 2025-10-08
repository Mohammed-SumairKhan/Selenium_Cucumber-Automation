Feature: Search with multiple input
Background:
Given I open the application


Scenario Outline:Verify search functionality for multiple inputs

Given 	I Login in the application 
When 	I search with "<searchText>"
Then 	I check for expected results contains "<searchText>"

Examples:
		
		|searchText|
		|Rohan|
		|Aadhar Changes|
		|1234567890|
		|TSK004|	   
		

Scenario: clear search button functionality

Given I Login in the application
And I have entered "rohon" in the search bar
When I click the clear search button
Then the search bar should be empty
