Feature: View Invoices

  Scenario: View a list of all invoices
    Given the customer is logged into the application
    When the customer views their invoices
    Then a list of invoices should be displayed
