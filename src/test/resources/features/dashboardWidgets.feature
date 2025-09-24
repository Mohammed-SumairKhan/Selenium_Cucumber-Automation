Feature: Widget Navigation

Background:
Given I open the application

Scenario Outline: Verify that clicking each widget navigates to the correct webpage
  Given I log in to the application
  When I click "<Widget>" widget
  Then I should navigate to Specific webpage and url contains "<url-text>"

Examples:
  | Widget          | url-text          |
  | Total Customers | customer    		| 
  | Tasks           | task-list         | 
  | Employees       | employee_list     | 
  | Payments        | payments          | 
