package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StartSessionStep {
    @And("has selected a charging station from the location list")
    public void hasSelectedAChargingStationFromTheLocationList() {
    }

    @And("the selected charging station is available")
    public void theSelectedChargingStationIsAvailable() {
    }

    @Then("the charging session begins at the selected station")
    public void theChargingSessionBeginsAtTheSelectedStation() {
    }

    @Given("the charging session is active at a selected station")
    public void theChargingSessionIsActiveAtASelectedStation() {
    }

    @When("the customer navigates to {string}")
    public void theCustomerNavigatesTo(String arg0) {
    }

    @Then("the current charging progress is displayed")
    public void theCurrentChargingProgressIsDisplayed() {
    }

    @And("the estimated completion time is shown")
    public void theEstimatedCompletionTimeIsShown() {
    }

    @And("a button {string} is available")
    public void aButtonIsAvailable(String arg0) {
    }
}
