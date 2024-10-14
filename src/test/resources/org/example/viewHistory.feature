Feature: View Usage History

  Scenario: View charging history
    Given the customer is logged into their account
    When the customer navigates to "Usage History"
    And selects the option to "View Charging History"
    Then a list of past charging sessions is displayed with details for each session, including date, location, charging type (AC or DC), duration, and cost

  Scenario: View account top-up history
    Given the customer is logged into their account
    When the customer navigates to "Usage History"
    And selects the option to "View Top-Up History"
    Then a list of past account top-ups is displayed with details for each transaction, including date, top-up amount, and payment method
