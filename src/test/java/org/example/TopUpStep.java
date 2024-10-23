package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopUpStep {
    private App app = new App();;
    private Customer customer = (Customer) app.login("customer1@example.com", "password");;
    private Customer customer2;
    private double initialBalance;
    private Exception topUpErrorMessage;

    public TopUpStep() throws LoginException {
    }

    @Given("the customer is logged into the App")
    public void theCustomerIsLoggedIn() {

        assertTrue(customer != null, "Customer login failed.");
        initialBalance = customer.getBalance();
    }

    @When("the customer requests to top up their account with {double}")
    public void theCustomerRequestsToTopUpTheirAccountWith(double amount) {
        try {
            customer.topUp(amount);
        } catch (TopUpException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the customer's account balance should increase by {double}")
    public void theCustomerAccountBalanceShouldIncreaseBy(double amount) {
        double expectedBalance = initialBalance + amount;
        assertEquals(expectedBalance, customer.getBalance(), "The account balance did not increase correctly.");
    }
    @Given("the balance is {int} euros")
    public void theBalanceIs(int balance) {
        customer2 = new Customer("Customer1",
                "customer1@example.com", "222222222",
                "password", 1, "credit card", balance);

    }
    @When("the customer tries to add {int} euros")
    public void theCustomerTriesToAddEuros(int amount) {
        try {
            customer2.topUp(amount);
        } catch (TopUpException e) {
            topUpErrorMessage = e;
        }
    }
    @Then("an error message {string} should be displayed for top-up")
    public void anErrorMessageShouldBeDisplayedForTopUp(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, topUpErrorMessage.getMessage());
    }
}
