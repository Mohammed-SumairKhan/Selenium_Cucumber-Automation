Feature: Direct dashboard access restriction

  Scenario: User tries to access dashboard directly without login
  Given  I open the browser
    When I navigate to "http://sumanvi.pythonanywhere.com/dashboard/"
    Then I should be redirected to the login page
