package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerLoginSteps {
    App app = new App();
    Account loggedInAccount;

    @Given("the customer is on the login page")
    public void theCustomerIsOnTheLoginPage() {
        // Navigate to the login page (setup step)
    }

    @When("the customer enters their email and password")
    public void theCustomerEntersEmailAndPassword() {
        loggedInAccount = app.login("email@example.com", "password");
    }

    @Then("the customer gains access to their account")
    public void theCustomerGainsAccessToTheirAccount() {
        assert loggedInAccount != null : "Login failed - account not found.";
    }
}
