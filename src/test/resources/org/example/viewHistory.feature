Feature: View Charging History

  Background: Given the customer is logged in

  Scenario: Customer views their charging history

    When the customer has a history and accesses the charging history page
    Then the customer's charging history should be displayed

    #ErrorCase

    Scenario:
      When the customer want to see the history despite not having one
      Then the Error message "You do not have a history yet" is accures