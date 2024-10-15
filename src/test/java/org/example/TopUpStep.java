package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopUpStep {
    private App app;
    private Customer customer;
    private double initialBalance;

    @Given("the customer is logged into the App")
    public void theCustomerIsLoggedIn() {
        app = new App();
        app.initialize();
        customer = (Customer) app.login("customer1@example.com", "password");
        assertTrue(customer != null, "Customer login failed.");
        initialBalance = customer.getBalance();
    }

    @When("the customer requests to top up their account with {double}")
    public void theCustomerRequestsToTopUpTheirAccountWith(double amount) {
        customer.topUp(amount);
    }

    @Then("the customer's account balance should increase by {double}")
    public void theCustomerAccountBalanceShouldIncreaseBy(double amount) {
        double expectedBalance = initialBalance + amount;
        assertEquals(expectedBalance, customer.getBalance(), "The account balance did not increase correctly.");
    }
}
