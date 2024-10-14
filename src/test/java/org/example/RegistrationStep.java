package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStep {
    @Given("the customer is on the registration page")
    public void theCustomerIsOnTheRegistrationPage() {
    }

    @When("the customer enters their email address, phone number, and password")
    public void theCustomerEntersTheirEmailAddressPhoneNumberAndPassword() {
    }

    @And("provides payment information \\(credit card or bank card)")
    public void providesPaymentInformationCreditCardOrBankCard() {
    }

    @And("submits the registration form")
    public void submitsTheRegistrationForm() {
    }

    @Then("the customer receives a unique Customer ID")
    public void theCustomerReceivesAUniqueCustomerID() {
    }

    @And("the account is created with the provided details")
    public void theAccountIsCreatedWithTheProvidedDetails() {
    }
}
