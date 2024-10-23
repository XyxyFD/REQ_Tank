package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetChargingPricesStep {
    App app;
    private Owner owner;
    private Location selectedLocation;
    Exception setChargingPriceError;

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
        try {
            owner.setACPrice(selectedLocation, acPrice);
        } catch (SetChargingPricesException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the AC charging price for {string} should be {double}")
    public void theACChargingPriceForShouldBe(String locationName, double expectedACPrice) {
        assertEquals(expectedACPrice, selectedLocation.getAcPrice(),
                "The AC charging price should match the expected value.");
    }

    @When("the owner sets the DC charging price to {double}")
    public void theOwnerSetsTheDCChargingPriceTo(double dcPrice) {
        try {
            owner.setDCPrice(selectedLocation, dcPrice);
        } catch (SetChargingPricesException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the DC charging price for {string} should be {double}")
    public void theDCChargingPriceForShouldBe(String locationName, double expectedDCPrice) {
        assertEquals(expectedDCPrice, selectedLocation.getDcPrice(),
                "The DC charging price should match the expected value.");
    }
    @Given("the average AC price is {double}")
    public void theAverageACPriceIs(double averageACPrice) {
        assertEquals(averageACPrice, owner.getAverageACPrice());
    }

    @Given("the average DC price is {double}")
    public void theAverageDCPriceIs(double averageDCPrice) {
        assertEquals(averageDCPrice, owner.getAverageDCPrice());
    }

    @When("the owner tries to set the AC price to {double} euros")
    public void theOwnerTriesToSetTheACPriceToEurosAndTheDCPriceToEuros(double price) {
        try {
            owner.setACPrice(selectedLocation, -2.0);
        } catch (SetChargingPricesException e) {
            setChargingPriceError = e;
        }
    }


    @Then("an error message {string} should be thrown")
    public void anErrorMessageShouldBeThrown(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, setChargingPriceError.getMessage());
    }
    @When("the DC price is set to {double} euros")
    public void theDCPriceToDoubleEuros(double price) {
        try {
            owner.setDCPrice(selectedLocation, 1000);
        } catch (SetChargingPricesException e) {
            setChargingPriceError = e;
        }
    }

    @Then("the error message {string} should be thrown")
    public void theErrorMessageShouldBeThrown(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, setChargingPriceError.getMessage());
    }


}
