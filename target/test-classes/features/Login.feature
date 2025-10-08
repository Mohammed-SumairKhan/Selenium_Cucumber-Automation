Feature: Login Feature

Background:
	Given I open the application
	
  Scenario: Login With Valid Credentials
    Given I enter the email "admin" and password "admin123"
    And I click on Login
    Then Page URL contains "dashboard"

  Scenario: Login Invalid Credentials
    Given I enter Email as "admin" and Password as "admin1"
    And I click on Login
    Then Page URL contains "login"
