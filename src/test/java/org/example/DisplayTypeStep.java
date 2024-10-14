package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayTypeStep {
    @Given("the owner has displayed the list of locations")
    public void theOwnerHasDisplayedTheListOfLocations() {
    }

    @And("the owner has selected a charging point")
    public void theOwnerHasSelectedAChargingPoint() {
    }

    @Given("the selected charging point is of type AC")
    public void theSelectedChargingPointIsOfTypeAC() {
    }

    @When("the owner views the charging point details")
    public void theOwnerViewsTheChargingPointDetails() {
    }

    @Then("the type {string} should be displayed")
    public void theTypeShouldBeDisplayed(String arg0) {
    }

    @Given("the selected charging point is of type DC")
    public void theSelectedChargingPointIsOfTypeDC() {
    }
}
