Feature: feature to test login functinality

  @smoketest
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <email> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | email        | password |
      | admin@admin.com | admin    |
      