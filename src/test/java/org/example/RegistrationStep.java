package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationStep {
    App app = new App();
    Account account;
    String email;
    String phoneNumber;
    String password;
    String paymentInfo;
    Customer newCustomer;
    private String registrationErrorMessage;
    Exception registrationException;

    @Given("the customer is on the registration page")
    public void theCustomerIsOnTheRegistrationPage() {
        // Navigiere zur Registrierungsseite - ggf. nur eine Bestätigung, dass die App initialisiert ist.
        System.out.println("Customer navigated to the registration page.");
    }

    @When("the customer enters their email address, phone number, and password")
    public void theCustomerEntersTheirEmailAddressPhoneNumberAndPassword() {
        // Setzt Beispielwerte - die könnten auch dynamisch vom Test-Framework kommen.
        email = "newcustomer@example.com";
        phoneNumber = "123456789";
        password = "securePassword";
        System.out.println("Entered email: " + email);
        System.out.println("Entered phone number: " + phoneNumber);
        System.out.println("Entered password.");
    }

    @And("provides payment information \\(credit card or bank card)")
    public void providesPaymentInformationCreditCardOrBankCard() {
        // Setzt Beispielwert für Zahlungsmethode - könnte erweitert werden, um mehr Details zu erfassen.
        paymentInfo = "Credit Card";
        System.out.println("Provided payment information: " + paymentInfo);
    }

    @And("submits the registration form")
    public void submitsTheRegistrationForm() {
        // Sendet das Registrierungsformular ab und erstellt den Kunden in der App.
        try {
            newCustomer = app.register(email, phoneNumber, password, paymentInfo);
        } catch (RegistrationException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(newCustomer, "Customer registration failed. Customer should not be null.");
    }

    @Then("the customer receives a unique Customer ID")
    public void theCustomerReceivesAUniqueCustomerID() {
        // Überprüft, ob der Kunde eine eindeutige ID hat.
        assertNotNull(newCustomer.getId(), "Customer ID should not be null.");
        System.out.println("Customer ID: " + newCustomer.getId());
    }

    @And("the account is created with the provided details")
    public void theAccountIsCreatedWithTheProvidedDetails() {
        // Verifiziert, ob die Kundeninformationen korrekt sind.
        assertEquals(email, newCustomer.getEmail(), "Email should match.");
        assertEquals(phoneNumber, newCustomer.getPhoneNumber(), "Phone number should match.");
        assertEquals(paymentInfo, newCustomer.getPayment(), "Payment information should match.");
        System.out.println("Account created with correct details.");
    }

    @Given("the system is initialized")
    public void theSystemIsInitialized() {
    }

    @When("the user registers with email {string}, phone {string}, password {string}, and payment info {string}")
    public void theUserRegistersWithEmailPhonePasswordAndPaymentInfo(String email, String phone, String password, String paymentInfo) {

        try {
            newCustomer = app.register(email, phone, password, paymentInfo);
        } catch (RegistrationException e) {
            registrationErrorMessage = e.getMessage();
        }
    }

    @Then("the error message {string} should be shown")
    public void theErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, registrationErrorMessage);
    }

    @When("the user tries to register with email {string} and password {string}")
    public void theUserTriesToRegisterWithEmailAndPassword(String email, String password) {
        app = new App();
        try {
            app.register(email, "123456789", password, "credit card");
            registrationException = null;
        } catch (RegistrationException e) {
            registrationException = e;
        }
    }
    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        assertNotNull(registrationException);
        assertEquals(expectedMessage, registrationException.getMessage());
    }
}
