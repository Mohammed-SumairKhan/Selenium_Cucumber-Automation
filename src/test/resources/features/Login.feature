Feature: Login Feature

  Scenario: Search Successful Login With Valid Credentials
    Given I Lunch Chrome Browser
    When I Opens URL
    And I Enter Email as "admin" and Password  as "admin123"
    And Click on Login
    Then Page Url Conatins "dashboard"
    And Close Browser

    Scenario Outline:
	Given I Lunch Chrome Browser
    When I Opens URL
    And I Enter Email as "<email>" and Password  as "<password>"
    And Click on Login
    Then Page Url Conatins "dashboard"
    And Close Browser
    
    Examples:
    |email   |   |password|  
	|admin   |   |admin123|
	|admin123|   |admin12 |