Feature: View Invoices

  Scenario: Display a list of invoices
    Given the customer is logged into their account
    When the customer selects the option to "View Invoices"
    Then a list of invoices is displayed, each with an invoice item number and location name

  Scenario: View invoice details
    Given the list of invoices is displayed
    When the customer selects a specific invoice by its item number
    Then the invoice details are shown, including:
      | Field                    | Description                        |
      | Invoice Item Number      | Unique identifier for the invoice  |
      | Location Name            | Name of the charging location      |
      | Charging Point           | Specific point where charging occurred |
      | Charging Mode            | Type of charging (AC or DC)        |
      | Duration of Use          | Length of the charging session     |
      | Charged Energy           | Amount of energy used (kWh)        |
      | Price                    | Total cost of the session          |
