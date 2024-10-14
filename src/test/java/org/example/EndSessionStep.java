package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndSessionStep {
    @Given("a charging session is in progress")
    public void aChargingSessionIsInProgress() {
    }

    @When("the customer selects the button {string}")
    public void theCustomerSelectsTheButton(String arg0) {
    }

    @Then("the charging session ends at the selected station")
    public void theChargingSessionEndsAtTheSelectedStation() {
    }

    @And("the availability status is updated to {string}")
    public void theAvailabilityStatusIsUpdatedTo(String arg0) {
    }

    @And("a summary of the session, including duration and energy consumed, is displayed")
    public void aSummaryOfTheSessionIncludingDurationAndEnergyConsumedIsDisplayed() {
    }

    @Given("the charging session has ended")
    public void theChargingSessionHasEnded() {
    }

    @When("the customer views the session summary")
    public void theCustomerViewsTheSessionSummary() {
    }

    @Then("the total cost of the session is calculated based on the duration and energy consumed")
    public void theTotalCostOfTheSessionIsCalculatedBasedOnTheDurationAndEnergyConsumed() {
    }

    @And("the customer’s account balance is updated to reflect the deducted amount")
    public void theCustomerSAccountBalanceIsUpdatedToReflectTheDeductedAmount() {
    }

    @And("a confirmation message showing the updated balance is displayed")
    public void aConfirmationMessageShowingTheUpdatedBalanceIsDisplayed() {
    }
}
