#Author: prateeksethiDev@gmail.com
@First
Feature: User should be able to add product to the Cart

  Background: User is Logged In
    Given User has already login in to the application
    |username|password|
    |user2@testemail.com|testqa|


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
