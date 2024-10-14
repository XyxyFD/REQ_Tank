package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class SetChargingPricesSteps {
    Owner owner = new Owner("Owner", "owner@example.com", "123456789", "password");
    Map<String, Double> prices = new HashMap<>();

    @When("the owner sets AC and DC prices for a location")
    public void theOwnerSetsPricesForLocation() {
        prices.put("AC", 0.3);
        prices.put("DC", 0.5);
        owner.setPrices("Location1", prices);
    }

    @Then("the charging prices are updated")
    public void chargingPricesAreUpdated() {
        assert owner.getPrices("Location1").get("AC") == 0.3 && owner.getPrices("Location1").get("DC") == 0.5;
    }
}
