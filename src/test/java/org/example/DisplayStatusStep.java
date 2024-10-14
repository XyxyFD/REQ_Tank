package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayStatusStep {
    @Given("the owner has opened the list of locations")
    public void theOwnerHasOpenedTheListOfLocations() {
    }

    @When("the owner selects a charging station")
    public void theOwnerSelectsAChargingStation() {
    }

    @Then("the operational status {string}, {string}, or {string} is displayed")
    public void theOperationalStatusOrIsDisplayed(String arg0, String arg1, String arg2) {
    }
}
