Feature: Functionality test on navigation menu

Background:
    Given I open the application

Scenario Outline: When clicking to navigate to the right webpage
    Given I am logged into the application
    When I click "<navigate>"
    Then I will navigate to the correct webpage "<url>"

Examples:
    |navigate     |url          |
    |new leads    |new-lead     |
    |all leads    |all_leads    |
    |customer     |customer     |
    |add services |add-services |
    |add employee |add-employee |
    |add task     |add-task     |
