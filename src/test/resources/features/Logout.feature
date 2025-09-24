Feature: Logout functionality

Background:
Given I open the application

Scenario: User successfully logs out


Given I logged in to the application
When I clicks the "Logout" button
Then I should be redirected to the login page
