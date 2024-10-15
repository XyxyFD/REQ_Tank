Feature: Select a charging station
  As a customer
  I want to select an available charging station
  So that the station becomes occupied

  Background:
    Given the system is initialized with locations and stations

  Scenario: Selecting an available charging station
    Given the charging station "CS1" is available at location "Main Station"
    When the customer selects the charging station "CS1"
    Then the status of the charging station "CS1" should be "occupied"
