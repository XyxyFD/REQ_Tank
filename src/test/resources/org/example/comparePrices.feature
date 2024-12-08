Feature: View and Compare Charging Prices
  Background:
    Given the customer is logged into their account

  Scenario: Check price overview for different locations and charging types
    Given the customer is logged into their account
    When the customer selects the option to "View Price Overview"
    Then a list of locations is displayed with prices for AC and DC charging at each location

  Scenario: Compare prices between locations for AC and DC charging
    Given the customer is viewing the price overview
    When the customer selects two or more locations to compare
    Then the prices for AC and DC charging are shown side by side for the selected locations
    And the customer can see the price differences between locations and charging types

    #ErrorCase

  Scenario: Compare prices between locations for AC and DC charging
    When the customer does not select a station and compares prices
    Then the Error message "You have not selected a station" should be presented
