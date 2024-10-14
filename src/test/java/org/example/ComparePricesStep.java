package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComparePricesStep {
    @Given("the customer is logged into their account")
    public void theCustomerIsLoggedIntoTheirAccount() {
    }

    @When("the customer selects the option to {string}")
    public void theCustomerSelectsTheOptionTo(String arg0) {
    }

    @Then("a list of locations is displayed with prices for AC and DC charging at each location")
    public void aListOfLocationsIsDisplayedWithPricesForACAndDCChargingAtEachLocation() {
    }

    @Given("the customer is viewing the price overview")
    public void theCustomerIsViewingThePriceOverview() {
    }

    @When("the customer selects two or more locations to compare")
    public void theCustomerSelectsTwoOrMoreLocationsToCompare() {
    }

    @Then("the prices for AC and DC charging are shown side by side for the selected locations")
    public void thePricesForACAndDCChargingAreShownSideBySideForTheSelectedLocations() {
    }

    @And("the customer can see the price differences between locations and charging types")
    public void theCustomerCanSeeThePriceDifferencesBetweenLocationsAndChargingTypes() {
    }
}
