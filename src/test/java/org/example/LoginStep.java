package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginStep {
    App app;
    Customer customer;

    @Given("the customer is on the login page")
    public void theCustomerIsOnTheLoginPage() {
        // Erstelle die App und initialisiere, damit alle Konten vorhanden sind
        app = new App();
        app.initialize();
        System.out.println("Customer navigated to the login page.");
    }

    @When("the customer enters their email address and password")
    public void theCustomerEntersTheirEmailAddressAndPassword() {
        // Login des Kunden mit Email und Passwort
        customer = (Customer) app.login("customer1@example.com", "password");
        assertNotNull(customer, "Customer should be successfully logged in.");
    }

    @Then("the customer is granted access to their account")
    public void theCustomerIsGrantedAccessToTheirAccount() {
        // Überprüfen, ob der Kunde erfolgreich eingeloggt wurde
        assertNotNull(customer, "Customer should be successfully logged in.");
        System.out.println("Customer has access to their account.");
    }
}
