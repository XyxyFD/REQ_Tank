package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ViewPricesSteps {
    Location location = new Location("Location1", "City1", List.of(new ChargingStation("CS1", StationType.AC, StationStatus.available)));

    @When("the customer views charging prices for different locations")
    public void theCustomerViewsChargingPrices() {
        location.displayPrices();
    }

    @Then("prices are displayed for AC and DC charging at all locations")
    public void pricesDisplayedForAllLocations() {
        Map<String, Double> prices = location.displayPrices();
        assert prices.containsKey("AC") && prices.containsKey("DC") : "Prices not displayed correctly.";
    }
}
