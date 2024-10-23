package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ViewInvoicesCustomerStep {
    private App app;
    private Customer customer;
    private List<Invoice> invoices;

    @Given("the customer is logged into the application")
    public void theCustomerIsLoggedIntoTheApplication() {
        app = new App();
        app.initialize();
        try {
            customer = (Customer) app.login("customer1@example.com", "password");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the customer views their invoices")
    public void theCustomerViewsTheirInvoices() {
        invoices = customer.getInvoices(); // Assuming getInvoices() returns a list of Invoice objects
    }

    @Then("a list of invoices should be displayed")
    public void aListOfInvoicesShouldBeDisplayed() {
        assertFalse(invoices.isEmpty(), "Expected invoices list to be non-empty, but it was empty.");
        invoices.forEach(invoice -> System.out.println("Invoice: " + invoice.toString()));
    }
}
