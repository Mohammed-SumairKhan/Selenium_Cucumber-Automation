Feature: Logout functionality

Background:
Given I open the application

Scenario: User successfully logs out

Given I logged in to the application
When  I click the Logout button
Then  I should be redirected to the login page

Scenario:  User successfully logs out2

Given I logged in to the application
When  I click the admin drop down
And   I click Logout link
Then  I should be redirected to the login page


