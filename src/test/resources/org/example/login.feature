Feature: Customer Login

  Scenario: Log in with email and password
    Given the customer is on the login page
    When the customer enters their email address and password
    Then the customer is granted access to their account