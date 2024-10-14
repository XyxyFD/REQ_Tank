Feature: Display all locations and number of charging stations
  As an owner
  I want to see a list of all locations and the number of charging stations at each location
  So that I have a comprehensive overview of my charging network

  Background:
    Given the owner is logged into the system

  Scenario: Display a list of all locations
    When the owner selects the option to "View Locations"
    Then the following list of locations should be displayed
    And the number of charging stations should be displayed
      | Location Name | City         | Number of Stations |
      | Main Station  | Vienna       | 5                  |
      | Central Park  | Salzburg     | 3                  |
      | East Station  | Linz         | 7                  |
