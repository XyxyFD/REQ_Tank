Feature: Display operational status of charging stations

  Background:
    Given the owner has opened the list of locations

  Scenario: Show operational status for each charging station
    When the owner views the list of all charging stations
    Then the following status of each charging station should be displayed
      | Charging Station ID | Status       |
      | CS1                 | available    |
      | CS2                 | occupied     |
      | CS3                 | available    |
      | CS4                 | outOfOrder   |
