package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewHistoryStep {
    private App app;
    private Customer customer;

    @Given("the customer is logged in")
    public void theCustomerIsLoggedIn() {
        app = new App();
        app.initialize();
        try {
            customer = (Customer) app.login("customer1@example.com", "password");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertTrue(customer != null, "Customer login failed.");
    }

    @When("the customer accesses the charging history page")
    public void theCustomerAccessesTheChargingHistoryPage() {
        // Simulate customer accessing the charging history
        assertFalse(customer.viewHistory().isEmpty(), "No history available.");
    }

    @Then("the customer's charging history should be displayed")
    public void theCustomerChargingHistoryShouldBeDisplayed() {
        // Check that the history is displayed correctly
        for (String entry : customer.viewHistory()) {
            System.out.println("History entry: " + entry);
        }
    }
}
