package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStep {
    App app = new App();
    Customer customer;
    Account account;
    String loginErrorMessage;

    @Given("the customer is on the login page")
    public void theCustomerIsOnTheLoginPage() {
        // Erstelle die App und initialisiere, damit alle Konten vorhanden sind
        System.out.println("Customer navigated to the login page.");
    }

    @When("the customer enters their email address and password")
    public void theCustomerEntersTheirEmailAddressAndPassword() {
        // Login des Kunden mit Email und Passwort
        try {
            customer = (Customer) app.login("customer1@example.com", "password");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(customer, "Customer should be successfully logged in.");
    }

    @Then("the customer is granted access to their account")
    public void theCustomerIsGrantedAccessToTheirAccount() {
        // Überprüfen, ob der Kunde erfolgreich eingeloggt wurde
        assertNotNull(customer, "Customer should be successfully logged in.");
        System.out.println("Customer has access to their account.");
    }


    @When("the user enters email {string} and password {string}")
    public void theUserEntersEmailAndPassword(String email, String password) {
        try {
            account = app.login(email, password);
        } catch (LoginException e) {
            loginErrorMessage = e.getMessage();
        }


    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String errorMessage) {
        System.out.println(loginErrorMessage);
        assertEquals(errorMessage, loginErrorMessage);
    }

    @When("the user enters the email {string} and password {string}")
    public void theUserEntersCorrectEmailAndWrongPassword(String email, String password) {
        try {
            account = app.login(email, password);
        } catch (LoginException e) {
            loginErrorMessage = e.getMessage();
        }


    }

    @Then("the error {string} should be displayed")
    public void theErrorShouldBeDisplayed(String errorMessage) {
        System.out.println(loginErrorMessage);
        assertEquals(errorMessage, loginErrorMessage);
    }
}
