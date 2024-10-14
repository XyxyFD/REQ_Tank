package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerRegistrationSteps {
    App app = new App();
    Customer registeredCustomer;

    @Given("the customer is on the registration page")
    public void theCustomerIsOnTheRegistrationPage() {
        // Setup step to simulate navigation to the registration page
    }

    @When("the customer enters their details and submits the registration form")
    public void theCustomerEntersDetailsAndSubmits() {
        app.register("email@example.com", "123456789", "password", "credit card", true);
        registeredCustomer = (Customer) app.login("email@example.com", "password");
    }

    @Then("the customer account is created with a unique Customer ID")
    public void theCustomerAccountIsCreated() {
        assert registeredCustomer != null && registeredCustomer.getId() != 0 : "Customer ID not created.";
    }
}
