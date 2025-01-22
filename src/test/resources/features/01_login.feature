Feature: Login to LC Waikiki

  Scenario: Successful login
    Given I navigate to loginPage
    When I enter a valid "email" and click on the "Devam" button
    And I enter a valid "password" and click on the "Giriş Yap" button to log in
    Then I should be logged in successfully
