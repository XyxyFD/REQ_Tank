
Feature: Customer Registration

  Background: Given the system is initialized

  Scenario: Register a new customer account
    Given the customer is on the registration page
    When the customer enters their email address, phone number, and password
    And provides payment information (credit card or bank card)
    And submits the registration form
    Then the customer receives a unique Customer ID
    And the account is created with the provided details

    #ErrorCases
  Scenario: User tries to register with an existing email
    When the user registers with email "customer1@example.com", phone "123456789", password "password", and payment info "credit card"
    Then the error message "Registration failed: Email already exists." should be shown

  Scenario: Register with a password shorter than 8 characters
    When the user tries to register with email "newuser@example.com" and password "short"
    Then an error message "Registration failed: Password must be at least 8 characters." should be displayed
