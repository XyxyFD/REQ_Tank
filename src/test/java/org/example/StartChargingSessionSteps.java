package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StartChargingSessionSteps {
    ChargingStation station = new ChargingStation("CS1", StationType.AC, StationStatus.available);

    @When("the customer starts the charging session")
    public void theCustomerStartsChargingSession() {
        station.startCharging();
    }

    @Then("the charging session is initiated")
    public void theChargingSessionIsInitiated() {
        assert station.checkStatus().equals("occupied") : "Charging session did not start.";
    }
}
