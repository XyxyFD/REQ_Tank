Feature: Customer Login

  Scenario: Log in with email and password
    Given the customer is on the login page
    When the customer enters their email address and password
    And clicks the "Log In" button
    Then the customer is granted access to their account

  Scenario: Log in with Customer ID and password
    Given the customer is on the login page
    When the customer enters their Customer ID and password
    And clicks the "Log In" button
    Then the customer is granted access to their account
