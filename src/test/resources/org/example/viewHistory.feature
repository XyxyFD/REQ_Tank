Feature: View Charging History

  Scenario: Customer views their charging history
    Given the customer is logged in
    When the customer accesses the charging history page
    Then the customer's charging history should be displayed
