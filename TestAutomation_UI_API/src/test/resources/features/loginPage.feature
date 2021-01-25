#Author: prateeksethiDev@gmail.com
#Keywords Summary : Scenarios covering Login Page


Feature: User should be able to interact with login page
  
 
  @First
  Scenario: Login Page Title
    Given User is on login page
    When User gets the title of the page
    Then Page title should be "STORE"
