package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ViewHistoryStep {
    @And("selects the option to {string}")
    public void selectsTheOptionTo(String arg0) {
    }

    @Then("a list of past charging sessions is displayed with details for each session, including date, location, charging type \\(AC or DC), duration, and cost")
    public void aListOfPastChargingSessionsIsDisplayedWithDetailsForEachSessionIncludingDateLocationChargingTypeACOrDCDurationAndCost() {
    }

    @Then("a list of past account top-ups is displayed with details for each transaction, including date, top-up amount, and payment method")
    public void aListOfPastAccountTopUpsIsDisplayedWithDetailsForEachTransactionIncludingDateTopUpAmountAndPaymentMethod() {
    }
}
