Feature: Set Charging Prices
  As an owner
  I want to set the charging prices for AC and DC stations at each location
  So that I can manage the costs for customers

  Background:
    Given the owner is logged into the Application

  Scenario: Set AC charging price for a location
    Given the owner has selected the location "Main Station"
    When the owner sets the AC charging price to 4.0
    Then the AC charging price for "Main Station" should be 4.0

  Scenario: Set DC charging price for a location
    Given the owner has selected the location "Central Park"
    When the owner sets the DC charging price to 5.0
    Then the DC charging price for "Central Park" should be 5.0

     # ErrorCases
  Scenario: Set charging prices with negative or excessive values
    Given the average AC price is 2.5
    When the owner tries to set the AC price to -2.0 euros
    Then an error message "Charging price cannot be negative" should be thrown

  Scenario: Set charging prices with negative or excessive values
    Given the average DC price is 2.5
    When the DC price is set to 1000 euros
    Then the error message "Charging price cannot be more than 1000% over the average." should be thrown