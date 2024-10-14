Feature: Display operational status of charging stations

  Background:
    Given the owner has opened the list of locations

  Scenario: Show operational status for each charging station
    When the owner selects a charging station
    Then the operational status "in operation free", "in operation occupied", or "out of order" is displayed
