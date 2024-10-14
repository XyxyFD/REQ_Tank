Feature: Start and Monitor Charging Session

  Scenario: Start a charging session
    Given the customer is logged into their account
    And has selected a charging station from the location list
    And the selected charging station is available
    When the customer selects the button "Select to charge"
    Then the charging session begins at the selected station
    And the availability status is updated to "occupied"

  Scenario: Monitor charging status
    Given the charging session is active at a selected station
    When the customer navigates to "View active charging session"
    Then the current charging progress is displayed
    And the estimated completion time is shown
    And a button "Stop charging" is available
