Feature: View and Select Invoices
  As an owner
  I want to see a list of all invoices
  So that I have a comprehensive overview of all transactions

  Scenario: Display a list of all invoices
    Given the system is initialized with invoices
    When the owner views all invoices
    Then the following list of invoices should be displayed
      | Invoice ID | Station ID   | Type | Duration | Energy Consumed | Total Cost | Tax |
      | INV001     | CS1          | AC   | 30       | 20.0            | 10.0       | 1.0 |
      | INV002     | CS3          | DC   | 45       | 25.0            | 15.0       | 1.5 |
