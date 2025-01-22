Feature: Product filtering in LC Waikiki

  Scenario: Filter products by age ,color and sales
    Given I am on the filter page
    When I filter products by age 5-6 Yaş
    And I filter products by age 6 Yaş
    And I filter products by age 6-7 Yaş
    And I filter products by color "Bej"
    And I filter products by most sales
    Then I should see products filtered by age and color
