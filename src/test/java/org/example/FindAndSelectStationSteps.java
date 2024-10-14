package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class FindAndSelectStationSteps {
    Location location = new Location("Location1", "City1", List.of(new ChargingStation("CS1", StationType.AC, StationStatus.available)));

    @When("the customer views the list of charging station locations")
    public void theCustomerViewsChargingStationLocations() {
        // Assuming viewAllLocations returns locations with charging stations
        location.getChargingStations();
    }

    @Then("a list of locations with charging stations is displayed")
    public void aListOfLocationsIsDisplayed() {
        assert location.getChargingStations().size() > 0 : "No charging stations found.";
    }
}
