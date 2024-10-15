package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EndSessionStep {

    private App app;
    private ChargingStation selectedStation;

    @Given("the system has initialized locations and charging stations")
    public void theSystemIsInitializedWithLocationsAndStations() {
        app = new App();
        app.initialize(); // Initialisiert die App und fügt Standorte und Ladestationen hinzu
    }

    @Given("the charging station {string} is occupied at location {string}")
    public void theChargingStationIsOccupiedAtLocation(String stationId, String locationName) {
        selectedStation = app.getLocations().stream()
                .filter(location -> location.getName().equals(locationName))
                .flatMap(location -> location.getChargingStations().stream())
                .filter(station -> station.getId().equals(stationId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Charging station not found"));

        selectedStation.setStatus(StationStatus.occupied); // Setzt den Status auf occupied für den Test
    }

    @When("the customer ends the session at the charging station {string}")
    public void theCustomerEndsTheSessionAtTheChargingStation(String stationId) {
        selectedStation.setStatus(StationStatus.available); // Setzt den Status zurück auf available
    }

    @Then("verify the charging station's status as {string} for {string}")
    public void verifyTheChargingStationsStatusAs(String status, String stationName) {
        // Implementierung bleibt gleich
    }
}
