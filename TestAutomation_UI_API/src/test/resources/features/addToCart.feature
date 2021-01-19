#Author: prateeksethiDev@gmail.com
Feature: User should be able to add product to the Cart

	@First
  Scenario: Login Page Title
    Given User is on login page
    When User gets the title of the page
    Then Page title should be "STORE"

  @First
  Scenario Outline: User can select category, search product and add to cart
    Given User is on Home Page
    When User is navigated to <product_category>
    And User select <product_name>
    And Click on add to cart and accept confirmation popup
    Then Item <product_name> should be added in the cart

    Examples: 
      | product_category | product_name |
      | Laptop           | Sony vaio i5 |
      | Laptop           | Dell i7 8gb  |