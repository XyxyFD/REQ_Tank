package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComparePricesStep {
    App app = new App();
    Customer customer;
    Exception compareError;

    @Given("the customer is logged into their account")
    public void theCustomerIsLoggedIntoTheirAccount() {
        // Log in and initialize the customer
        try {
            customer = (Customer) app.login("customer1@example.com", "password");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(customer, "Customer should be logged in successfully");
    }

    @When("the customer selects the option to \"View Price Overview\"")
    public void theCustomerSelectsTheOptionToViewPriceOverview() {
        // Check price overview
        List<String> priceOverview = customer.viewPriceOverview();
        assertNotNull(priceOverview, "Price overview should not be null");
        assertFalse(priceOverview.isEmpty(), "Price overview should not be empty");
    }

    @Then("a list of locations is displayed with prices for AC and DC charging at each location")
    public void aListOfLocationsIsDisplayedWithPricesForACAndDCChargingAtEachLocation() {
        // Validate price overview for each location
        List<String> priceOverview = customer.viewPriceOverview();
        for (String entry : priceOverview) {
            System.out.println(entry);  // Output the overview (useful for debugging)
            assertTrue(entry.contains("AC:") && entry.contains("DC:"),
                    "Each entry should contain both AC and DC prices");
        }
    }

    @Given("the customer is viewing the price overview")
    public void theCustomerIsViewingThePriceOverview() {
        // Ensure customer can view the price overview
        List<String> priceOverview = customer.viewPriceOverview();
        assertNotNull(priceOverview, "Price overview should not be null when viewing");
        assertFalse(priceOverview.isEmpty(), "Price overview should be available when viewing");
    }

    @When("the customer selects two or more locations to compare")
    public void theCustomerSelectsTwoOrMoreLocationsToCompare() {
        // Additional logic to simulate selection of multiple locations (stub for now)
        System.out.println("Selected two or more locations for comparison.");
    }

    @Then("the prices for AC and DC charging are shown side by side for the selected locations")
    public void thePricesForACAndDCChargingAreShownSideBySideForTheSelectedLocations() {
        // Verify that prices for AC and DC charging are displayed side by side
        List<String> priceOverview = customer.viewPriceOverview();
        assertNotNull(priceOverview, "Prices should be available for comparison");
        assertTrue(priceOverview.size() >= 2, "There should be prices for at least two locations");
    }

    @And("the customer can see the price differences between locations and charging types")
    public void theCustomerCanSeeThePriceDifferencesBetweenLocationsAndChargingTypes() {
        // Check that the price differences are displayed
        List<String> priceOverview = customer.viewPriceOverview();
        assertTrue(priceOverview.stream().anyMatch(entry -> entry.contains("AC") && entry.contains("DC")),
                "Price differences should be visible for AC and DC between locations");
    }

    @When("the customer does not select a station and compares prices")
    public void theCustomerAddsTheLocation() {
        try {
            customer.comparePrices();
        } catch (Exception e) {
            compareError = e;
        }
    }

    @Then("the Error message {string} should be presented")
    public void theErrorMessageShouldBePresented(String errormessage) {
        assertEquals(compareError.getMessage(), errormessage);
    }
}
