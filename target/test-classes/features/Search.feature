@sanity
Feature: Search with multiple input
Background:
Given I Open application

@search
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