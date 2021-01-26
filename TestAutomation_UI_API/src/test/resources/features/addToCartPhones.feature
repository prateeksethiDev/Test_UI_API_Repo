#Author: prateeksethiDev@gmail.com
@First
Feature: User should be able to add phones to the Cart

  Background: User is Logged In
    Given User has already login in to the application
      | username            | password |
      | user2@testemail.com | testqa   |

  Scenario Outline: User can select category as Phones, search product and add to cart
    Given User is on Home Page
    When User add phone to cart from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then Item should be added in the cart as given sheetname "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | addToCartPhones |         0 |
