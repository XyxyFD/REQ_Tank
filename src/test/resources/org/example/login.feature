Feature: Customer Login

  Background: Given the customer is on the login page

  Scenario: Log in with email and password

    When the customer enters their email address and password
    Then the customer is granted access to their account

    #ErrorCases
  Scenario: User logs in with incorrect credentials
    When the user enters email "nonexistentuser@example.com" and password "wrongpassword"
    Then the error message "Login failed: Wrong Email or password." should be displayed

  Scenario: User tries to login with correct email but wrong password
    When the user enters the email "customer1@example.com" and password "wrongpassword"
    Then the error "Login failed: Wrong Email or password." should be displayed


