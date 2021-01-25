#Author: prateeksethiDev@gmail.com

@First
Feature: User should be able to delete already added product from the cart
  
  Background: User is Logged In
    Given User has already login in to the application
    |username|password|
    |user2@testemail.com|testqa|
  
  Scenario Outline: User should be able to delete the product from the cart
    Given User is on Home Page
    When User navigated to cart section
    And User delete the <product_name> from the cart
    Then Verify <product_name> not availble in cart

    Examples: 
      | product_name  | 
      | Dell i7 8gb | 
