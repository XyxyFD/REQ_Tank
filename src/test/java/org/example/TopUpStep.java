package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopUpStep {
    private App app = new App();;
    Customer customer = new Customer("Customer1", "customer1@example.com", "222222222", "password", 1,  0.0, "credit Card");
    Customer customer2;
    Customer customer3 = new Customer("Customer3", "customer3@example.com", "444444444", "password", 3,  0.0);
    private double initialBalance;
    private Exception topUpErrorMessage;
    private Exception paymentError;
    private Exception minimumTopUpAmountError;

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
        customer2  = new Customer("Customer2", "customer2@example.com", "333333333", "password", 2,  balance, "debit Card");
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

    @When("the customer tries to top up with {double} euros")
    public void theCustomerTriesToTopUpWithEuros(double amount) {
        try {
            customer3.topUp(amount);
        } catch (TopUpException e) {
            paymentError = e;
        }
    }

    @Then("an error message {string} should be shown")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        assertEquals(expectedMessage, paymentError.getMessage());
    }

    @Given("the balance is {double} €")
    public void theBalanceIs€(double initialBalance) {
        assertEquals( initialBalance, customer.getBalance());

    }

    @When("the customer wants to add {int} Euros to his Account")
    public void theCustomerWantsToAddEurosToHisAccount(int topUpAmount) {
        try {
            customer.topUp(topUpAmount);
        } catch (TopUpException e) {
            minimumTopUpAmountError = e;
        }
    }

    @Then("an Error message {string} is shown on the interface")
    public void anErrorMessageIsShownOnTheInterface(String expectedErrorMessage) {
        assertEquals(minimumTopUpAmountError.getMessage(), expectedErrorMessage);
    }
}
