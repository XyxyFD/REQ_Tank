package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SetChargingPricesStep {
    App app;
    private Owner owner;
    private Location selectedLocation;

    @Given("the owner is logged into the Application")
    public void theOwnerIsLoggedIntoTheSystem() {
        app = new App();
        owner = new Owner("Owner Name", "owner@example.com", "1234567890", "password");
    }

    @Given("the owner has selected the location {string}")
    public void theOwnerHasSelectedTheLocation(String locationName) {
        selectedLocation = App.getLocations().stream()
                .filter(location -> location.getName().equals(locationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Location not found"));
    }

    @When("the owner sets the AC charging price to {double}")
    public void theOwnerSetsTheACChargingPriceTo(double acPrice) {
        owner.setACPrice(selectedLocation, acPrice);
    }

    @Then("the AC charging price for {string} should be {double}")
    public void theACChargingPriceForShouldBe(String locationName, double expectedACPrice) {
        Assertions.assertEquals(expectedACPrice, selectedLocation.getAcPrice(),
                "The AC charging price should match the expected value.");
    }

    @When("the owner sets the DC charging price to {double}")
    public void theOwnerSetsTheDCChargingPriceTo(double dcPrice) {
        owner.setDCPrice(selectedLocation, dcPrice);
    }

    @Then("the DC charging price for {string} should be {double}")
    public void theDCChargingPriceForShouldBe(String locationName, double expectedDCPrice) {
        Assertions.assertEquals(expectedDCPrice, selectedLocation.getDcPrice(),
                "The DC charging price should match the expected value.");
    }
}
