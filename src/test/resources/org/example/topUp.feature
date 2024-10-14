Feature: Account Top-Up (Prepaid)

  Scenario: Select amount to top-up account
    Given the customer is logged into their account
    And is on the account top-up page
    When the customer selects an amount to add to their balance
    And confirms the selected amount
    Then the selected amount is prepared for payment

  Scenario: Complete account top-up
    Given the customer has selected an amount to top-up
    When the customer confirms the payment
    Then the account balance is increased by the selected amount
    And a confirmation message is displayed
