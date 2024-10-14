Feature: Display charging point type

  Background:
    Given the owner has displayed the list of locations
    And the owner has selected a charging point

  Scenario: Show AC type for a selected charging point
    Given the selected charging point is of type AC
    When the owner views the charging point details
    Then the type "AC" should be displayed

  Scenario: Show DC type for a selected charging point
    Given the selected charging point is of type DC
    When the owner views the charging point details
    Then the type "DC" should be displayed
