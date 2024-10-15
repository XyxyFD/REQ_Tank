package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayTypeStep {
    private App app;
    private Owner owner;
    private ChargingStation selectedStation;

    @Given("the owner has displayed the list of locations")
    public void theOwnerHasDisplayedTheListOfLocations() {
        app = new App();
        owner = new Owner("Owner Name", "owner@example.com", "111111111", "password");
        app.initialize();
        owner.viewAllStations();
    }

    @Given("the owner has selected a charging point")
    public void theOwnerHasSelectedAChargingPoint() {
        selectedStation = new ChargingStation("Station-1", StationType.AC, StationStatus.available);
    }

    @Given("the selected charging point is of type AC")
    public void theSelectedChargingPointIsOfTypeAC() {
        selectedStation.setType(StationType.AC);
    }

    @Given("the selected charging point is of type DC")
    public void theSelectedChargingPointIsOfTypeDC() {
        selectedStation.setType(StationType.DC);
    }

    @When("the owner views the charging point details")
    public void theOwnerViewsTheChargingPointDetails() {
        // Anzeige der Details der ausgewählten Ladestation
    }

    @Then("the type {string} should be displayed")
    public void theTypeShouldBeDisplayed(String expectedType) {
        assertEquals(expectedType, selectedStation.getType().toString(),
                "Charging station type should match the expected value.");
    }
}
