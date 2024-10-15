Feature: End a charging session
  As a customer
  I want to end my charging session
  So that the charging station becomes available again

  Background:
    Given the system has initialized locations and charging stations


  Scenario: Ending an occupied charging session
    Given the charging station "CS1" is occupied at location "Main Station"
    When the customer ends the session at the charging station "CS1"
    Then verify the charging station's status as "available" for "Main Station"

