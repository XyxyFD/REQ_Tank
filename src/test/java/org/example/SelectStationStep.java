package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SelectStationStep {

    private App app;
    private ChargingStation selectedStation;

    @Given("the system is initialized with locations and stations")
    public void theSystemIsInitializedWithLocationsAndStations() {
        app = new App();
        app.initialize(); // Initialisiert die App und fügt Standorte und Ladestationen hinzu
    }

    @Given("the charging station {string} is available at location {string}")
    public void theChargingStationIsAvailableAtLocation(String stationId, String locationName) {
        selectedStation = app.getLocations().stream()
                .filter(location -> location.getName().equals(locationName))
                .flatMap(location -> location.getChargingStations().stream())
                .filter(station -> station.getId().equals(stationId) && station.getStatus() == StationStatus.available)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Charging station not available"));
    }

    @When("the customer selects the charging station {string}")
    public void theCustomerSelectsTheChargingStation(String stationId) {
        selectedStation.setStatus(StationStatus.occupied); // Status der Station zu occupied ändern
    }

    @Then("the status of the charging station {string} should be {string}")
    public void theStatusOfTheChargingStationShouldBe(String stationId, String expectedStatus) {
        Assertions.assertEquals(StationStatus.valueOf(expectedStatus), selectedStation.getStatus(),
                "The status of the charging station should match the expected value.");
    }
}
