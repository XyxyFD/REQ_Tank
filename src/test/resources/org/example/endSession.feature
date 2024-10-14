Feature: End Charging Session and View Billing

  Scenario: End the charging session
    Given a charging session is in progress
    When the customer selects the button "Stop charging"
    Then the charging session ends at the selected station
    And the availability status is updated to "available"
    And a summary of the session, including duration and energy consumed, is displayed

  Scenario: View billing and update account balance
    Given the charging session has ended
    When the customer views the session summary
    Then the total cost of the session is calculated based on the duration and energy consumed
    And the customer’s account balance is updated to reflect the deducted amount
    And a confirmation message showing the updated balance is displayed
