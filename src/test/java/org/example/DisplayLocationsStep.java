package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayLocationsStep {
    private Owner owner;
    App app;
    private List<Location> displayedLocations;

    @Given("the owner is logged into the system")
    public void theOwnerIsLoggedIntoTheSystem() {
        owner = new Owner("Owner Name", "owner@example.com", "1234567890", "password");
        app = new App(); // Setzt die App mit Standorten initialisiert.
    }

    @When("the owner selects the option to \"View Locations\"")
    public void theOwnerSelectsTheOptionToViewLocations() {
        displayedLocations = owner.viewAllLocations();
    }

    @Then("the following list of locations should be displayed")
    public void theFollowingListOfLocationsShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        List<Location> expectedLocations = expectedData.stream()
                .map(row -> {
                    String stationCountStr = row.get("Number of Stations").trim();
                    int stationCount = Integer.parseInt(stationCountStr);

                    // Erstellen einer Dummy-Liste von ChargingStation-Objekten
                    List<ChargingStation> chargingStations = new ArrayList<>();
                    for (int i = 0; i < stationCount; i++) {
                        chargingStations.add(new ChargingStation("DummyStation" + i, StationType.AC, StationStatus.available));
                    }

                    return new Location(row.get("Location Name"), row.get("City"), chargingStations);
                })
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedLocations.size(), displayedLocations.size(), "Anzahl der Standorte sollte übereinstimmen.");

        for (int i = 0; i < expectedLocations.size(); i++) {
            Location expected = expectedLocations.get(i);
            Location actual = displayedLocations.get(i);
            Assertions.assertEquals(expected.getName(), actual.getName(), "Standortnamen sollten übereinstimmen.");
            Assertions.assertEquals(expected.getCity(), actual.getCity(), "Standortstädte sollten übereinstimmen.");
            Assertions.assertEquals(expected.getChargingStations().size(), actual.getChargingStations().size(), "Anzahl der Ladestationen sollte übereinstimmen.");
        }
    }


}
