Feature: Top Up Customer Balance

  Background: Given the customer is logged into the App

  Scenario: Customer tops up their account balance
    When the customer requests to top up their account with 50.0
    Then the customer's account balance should increase by 50.0

    #EdgeCases

  Scenario: Top up exceeds the balance limit
    Given the balance is 4000 euros
    When the customer tries to add 2000 euros
    Then an error message "Balance cannot exceed 5000 euros." should be displayed for top-up

    Scenario: Top up is below minimum top-up amount
      Given the balance is 0.0 €
      When the customer wants to add 5 Euros to his Account
      Then an Error message "You have to top-up at least 10 Euros" is shown on the interface

    #ErrorCase

  Scenario: Top up without payment information
    When the customer tries to top up with 100 euros
    Then an error message "Cannot top up: No payment information provided." should be shown