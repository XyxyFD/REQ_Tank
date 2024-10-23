Feature: Top Up Customer Balance

  Background: Given the customer is logged into the App

  Scenario: Customer tops up their account balance
    When the customer requests to top up their account with 50.0
    Then the customer's account balance should increase by 50.0

    #ErrorCases

  Scenario: Top up exceeds the balance limit
    Given the balance is 4000 euros
    When the customer tries to add 2000 euros
    Then an error message "Balance cannot exceed 5000 euros." should be displayed for top-up
