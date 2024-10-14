
Feature: View and select invoices

  Background:
    Given the owner is logged into the system

  Scenario: Display a list of all invoices with details
    When the owner selects the option to "View All Invoices"
    Then a list of invoices should be displayed with the following details for each invoice:
      | Invoice Item Number | Location Name | Price |

  Scenario: Select and view details of a specific invoice
    Given the list of invoices is displayed
    When the owner selects a specific invoice by clicking on its invoice item number
    Then the system displays the details for the selected invoice, including the location name, charging point, charging mode, duration of use, charged energy, and price
