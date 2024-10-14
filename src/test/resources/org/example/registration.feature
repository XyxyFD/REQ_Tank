
Feature: Customer Registration

  Scenario: Register a new customer account
    Given the customer is on the registration page
    When the customer enters their email address, phone number, and password
    And provides payment information (credit card or bank card)
    And submits the registration form
    Then the customer receives a unique Customer ID
    And the account is created with the provided details
