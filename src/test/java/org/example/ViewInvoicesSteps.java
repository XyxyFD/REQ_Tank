package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

public class ViewInvoicesSteps {
    Owner owner = new Owner("John Doe", "john@example.com", "123456789", "password");

    @When("the owner views the list of invoices")
    public void theOwnerViewsInvoices() {
        List<Invoice> invoices = owner.viewInvoices(); // Retrieve and use the list
    }

    @Then("the list of invoices is displayed")
    public void invoicesListDisplayed() {
        assert owner.viewInvoices().size() > 0; // Check that invoices are displayed
    }
}
