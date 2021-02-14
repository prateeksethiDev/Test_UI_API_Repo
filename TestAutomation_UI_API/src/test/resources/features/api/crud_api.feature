#Author: prateeksethiDev@gmail.com

@api
Feature: To verify the CRUD operation in Petstore API

  
  Scenario: Get available pets and verify the result
    Given I perform GET operation for "findByStatus" for "available" pets
    Then I validate the expected result
    
  Scenario Outline: Post a new available pet to the store. Assert new pet added.
  Given I perform POST operation "pet" to add new pet to the store
  Then  validate the new pet "goofy" added and is available