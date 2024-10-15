Feature: Top Up Customer Balance

  Scenario: Customer tops up their account balance
    Given the customer is logged into the App
    When the customer requests to top up their account with 50.0
    Then the customer's account balance should increase by 50.0
