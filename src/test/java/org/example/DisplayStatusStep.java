package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayStatusStep {
    private App app;
    private List<ChargingStation> displayedStations;

    @Given("the owner has opened the list of locations")
    public void theOwnerHasOpenedTheListOfLocations() {
        app = new App();
        displayedStations = new ArrayList<>();
        // Lädt alle Charging Stations aus den Locations
        for (Location location : app.getLocations()) {
            displayedStations.addAll(location.getChargingStations());
        }
    }

    @When("the owner views the list of all charging stations")
    public void theOwnerViewsTheListOfAllChargingStations() {
        // Die Charging Stations sind bereits geladen in displayedStations
    }

    @Then("the following status of each charging station should be displayed")
    public void theFollowingStatusOfEachChargingStationShouldBeDisplayed(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);

        // Nur 4 Stationen laden, basierend auf den 4 erwarteten aus initialize()
        Assertions.assertEquals(4, displayedStations.size(), "Die Anzahl der Ladestationen sollte übereinstimmen.");

        // Überprüfung der geladenen Daten
        for (Map<String, String> row : expectedData) {
            ChargingStation station = displayedStations.stream()
                    .filter(cs -> cs.getId().equals(row.get("Charging Station ID")))
                    .findFirst()
                    .orElse(null);
            Assertions.assertNotNull(station, "Die Ladestation mit der ID " + row.get("Charging Station ID") + " sollte vorhanden sein.");
            Assertions.assertEquals(StationStatus.valueOf(row.get("Status")), station.getStatus(), "Der Status der Ladestation " + station.getId() + " sollte übereinstimmen.");
        }
    }
}
