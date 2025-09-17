Feature: Search with multiple input

Scenario Outline:

Given 	I Login in the application 
When 	I search with "<searchText>"
Then 	I check for expected results contains "<searchText>"

Examples:
		
		|searchText|
		|Rohan|
		|Aadhar Changes|
		|1234567890|
		|TSK004|	   