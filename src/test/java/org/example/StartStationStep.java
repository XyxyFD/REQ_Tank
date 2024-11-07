package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartStationStep {

    private App app = new App();
    private ChargingStation selectedStation;
    Customer customer ; //(Customer) App.getAccounts().get(1);
    private ChargingStation occupiedStation = new ChargingStation("CS2", StationType.DC, StationStatus.occupied);
    private ChargingStation outOfOrderStation = new ChargingStation("CS4", StationType.DC, StationStatus.outOfOrder);
    private Exception exception;

    @Given("the system is initialized with locations and stations")
    public void theSystemIsInitializedWithLocationsAndStations() {
        customer = (Customer) App.getAccounts().get(1);

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
        assertEquals(StationStatus.valueOf(expectedStatus), selectedStation.getStatus(),
                "The status of the charging station should match the expected value.");
    }

    @When("the customer selects a charging station that is occupied")
    public void theCustomerSelectsAChargingStationWithId() {
        try {
            customer.startCharging(occupiedStation);
        } catch (Exception e) {
            exception = e; // Speichert die Exception, falls eine auftritt
        }
    }

    @Then("an error message {string} will be displayed")
    public void anErrorMessageWillBeDisplayed(String expectedError) {
        assertEquals(expectedError, exception.getMessage());
    }
    @When("the customer selects a charging station that is out of order")
    public void aChargingStationWithIDIsSelected() {
        try {
            customer.startCharging(outOfOrderStation);
        } catch (Exception e) {
            exception = e; // Speichert die Exception, falls eine auftritt
        }
    }

    @Then("the error message {string} will be displayed")
    public void theErrorMessageWillBeDisplayed(String expectedError) {
        assertEquals(expectedError, exception.getMessage());
    }


}
