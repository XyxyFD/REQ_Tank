package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class DisplayLocationsSteps {
    Owner owner = new Owner("Owner", "owner@example.com", "123456789", "password");
    List<Location> locations;

    @When("the owner views all charging locations")
    public void theOwnerViewsAllLocations() {
        locations = owner.viewAllLocations();
    }

    @Then("the locations are displayed for the owner")
    public void locationsDisplayedForOwner() {
        assert locations != null && locations.size() > 0 : "Locations not displayed.";
    }
}
