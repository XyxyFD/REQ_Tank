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
