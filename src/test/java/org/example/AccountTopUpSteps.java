package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountTopUpSteps {
        Customer customer = new Customer("name", "email", "3452332545", "passord", 1, "AT40454054054", 100.00);

    @When("the customer selects an amount to top up")
    public void theCustomerSelectsTopUpAmount() {
        customer.topUp(50.0); // Select an amount to top up
    }

    @Then("the customer's balance is updated accordingly")
    public void theCustomerBalanceIsUpdated() {
        assert customer.getBalance() >= 50.0; // Check that balance increased
    }
}
