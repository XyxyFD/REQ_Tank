package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class ViewHistoryStep {
    private App app = new App();
    private Customer customer = (Customer) App.getAccounts().get(1);
    private Exception noHistoryError;

    @Given("the customer is logged in")
    public void theCustomerIsLoggedIn() {

        assertTrue(customer != null, "Customer is logged in");
    }

    @When("the customer has a history and accesses the charging history page")
    public void theCustomerAccessesTheChargingHistoryPage() {
        customer.addHistory("Duration: 37 min, Cost: 8.50€");

    }

    @Then("the customer's charging history should be displayed")
    public void theCustomerChargingHistoryShouldBeDisplayed() {
        // Check that the history is displayed correctly
        try {
            for (String entry : customer.viewHistory()) {
                System.out.println("History entry: " + entry);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @When("the customer want to see the history despite not having one")
    public void theCustumerWantToSeeTheHistoryDespiteNotHavingOne() {
        customer.getHistory().removeAll(customer.getHistory());
        try {
            customer.viewHistory();
        } catch (Exception e) {
            noHistoryError = e;
        }
    }

    @Then("the Error message {string} is accures")
    public void theErrorMessageIsAccures(String expectedError) {
        assertEquals(noHistoryError.getMessage(), expectedError);
    }
}
