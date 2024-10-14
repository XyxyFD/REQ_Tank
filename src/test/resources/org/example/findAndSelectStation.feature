Feature: Find and Select Charging Station

  Scenario: Locate a charging station by site
    Given the customer is logged into their account
    When the customer clicks on the option "View locations"
    Then a list of all locations with charging stations is displayed

  Scenario: Check availability and type of charging station
    Given the customer clicked on "View locations"
    And the customer has selected a location
    When the customer has selected a location
    Then the availability status (available, occupied, or out of order) for each charging station is displayed
    And the type of each charging station (AC or DC) is shown
    And a button "Select to charge" is shown

  Scenario: Select a specific charging station
    Given the customer has viewed the list of available charging stations
    When the customer selects a charging station by its type and availability
    Then the selected charging station is highlighted for the customer
