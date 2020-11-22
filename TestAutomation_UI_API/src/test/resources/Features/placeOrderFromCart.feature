#Author: prateeksethiDev@gmail.com

@tag
Feature: User should be able to purchase product from cart

  @tag2
  Scenario Outline: User should be able to purchase product from cart page
    Given User is present on cart page
    When User clicks on place order button
    And  User provided the customer name <customer_name>
    And  User provided the country <country>
    And  User provided the city <city>
    And  User provided the credit card <credit_card_number>
    And  User provided the month <month>
    And  User provided the year <year>
    And  User clicks on purchase button
    Then Order should be placed successfully
    Then Amount of product should be <product_amount>

    Examples: 
      | customer_name | country | city  | credit_card_number | month | year | product_amount |
      | prateek | India | Noida | 11 | 10 | 2020 | 790 USD |
