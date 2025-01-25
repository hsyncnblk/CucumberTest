Feature: LC Waikiki Application

  Scenario: Complete user journey in LC Waikiki
    Given I navigate to loginPage
    When I enter a valid "email" and click on the "Devam" button
    And I enter a valid "password" and click on the "Giriş Yap" button to log in
    Then I should be logged in successfully
    And I am on the filter page
    When I filter products by age 5-6 Yaş
    And I filter products by age 6 Yaş
    And I filter products by age 6-7 Yaş
    And I filter products by color Bej
    And I filter products by most sales
    Then I should see products filtered by age and color
    And I am on the product detail page
    When I select a size for the product
    And I add the product to the cart
    Then I should see the product in the cart
    And I verify the product details in the cart
    When I increase the product quantity
    Then I verify the product quantity is updated
    And I add the product to favorites
    And I verify the product is successfully added to favorites
    Then I go to the cart