package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewInvoicesOwnerStep {
    private Owner owner;
    private List<Invoice> displayedInvoices;

    @Given("the system is initialized with invoices")
    public void theSystemIsInitializedWithInvoices() {
        owner = new Owner("Owner Name", "owner@example.com", "1234567890", "password");

        // Initialisiere Rechnungen und füge sie dem Owner hinzu
        Invoice invoice1 = new Invoice("INV001", "CS1", "AC", 30, 20.0, 10.0, 1.0);
        Invoice invoice2 = new Invoice("INV002", "CS3", "DC", 45, 25.0, 15.0, 1.5);

        // Füge die Rechnungen direkt zur Liste des Owners hinzu
        owner.addInvoice(invoice1);
        owner.addInvoice(invoice2);
    }

    @When("the owner views all invoices")
    public void theOwnerViewsAllInvoices() {
        displayedInvoices = owner.viewInvoices();
    }

    @Then("the following list of invoices should be displayed")
    public void theFollowingListOfInvoicesShouldBeDisplayed(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);

        // Mappen der Daten aus dem Feature-File in Invoice-Objekte
        List<Invoice> expectedInvoices = expectedData.stream()
                .map(row -> new Invoice(
                        row.get("Invoice ID"),
                        row.get("Station ID"),
                        row.get("Type"),
                        Integer.parseInt(row.get("Duration")),
                        Double.parseDouble(row.get("Energy Consumed")),
                        Double.parseDouble(row.get("Total Cost")),
                        Double.parseDouble(row.get("Tax"))
                ))
                .collect(Collectors.toList());

        // Sicherstellen, dass die Anzahl der Rechnungen übereinstimmt
        Assertions.assertEquals(expectedInvoices.size(), displayedInvoices.size(),
                "Die Anzahl der Rechnungen sollte übereinstimmen.");

        // Überprüfung der Details jeder Rechnung
        for (int i = 0; i < expectedInvoices.size(); i++) {
            Invoice expected = expectedInvoices.get(i);
            Invoice actual = displayedInvoices.get(i);

            Assertions.assertEquals(expected.getInvoiceId(), actual.getInvoiceId(),
                    "Die Rechnungs-IDs sollten übereinstimmen.");
            Assertions.assertEquals(expected.getStationId(), actual.getStationId(),
                    "Die Station-IDs sollten übereinstimmen.");
            Assertions.assertEquals(expected.getType(), actual.getType(),
                    "Die Typen sollten übereinstimmen.");
            Assertions.assertEquals(expected.getDuration(), actual.getDuration(),
                    "Die Dauer sollte übereinstimmen.");
            Assertions.assertEquals(expected.getEnergyConsumed(), actual.getEnergyConsumed(),
                    "Die verbrauchte Energie sollte übereinstimmen.");
            Assertions.assertEquals(expected.getTotalCost(), actual.getTotalCost(),
                    "Die Gesamtkosten sollten übereinstimmen.");
            Assertions.assertEquals(expected.getTax(), actual.getTax(),
                    "Die Steuern sollten übereinstimmen.");
        }
    }
}
