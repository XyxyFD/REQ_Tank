package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Account {
    private int id;
    private String payment;
    private double balance;
    private List<Invoice> invoices = new ArrayList<>();
    private List<String> history = new ArrayList<>();

    public Customer(String name, String email, String phoneNumber, String password, int id, String payment, double balance) {
        super(name, email, phoneNumber, password);
        this.id = id;
        this.payment = payment;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    @Override
    public void topUp(double amount) {
        this.balance += amount;
    }

    @Override
    public List<ChargingStation> viewAllStations() {
        List<ChargingStation> allStations = new ArrayList<>();

        for (Location location : App.getLocations()) {
            allStations.addAll(location.getChargingStations());
        }

        // Optional: Ausgabe zur Visualisierung der Liste
        System.out.println("ID | Type | Status");
        for (ChargingStation station : allStations) {
            System.out.println(station.getId() + " | " + station.getType() + " | " + station.getStatus());
        }

        return allStations;
    }


    @Override
    public List<Invoice> viewInvoices() {
        return invoices;
    }

    public void selectChargingStation(ChargingStation station) {
        if(station.getStatus().equals(StationStatus.available)){
            station.setStatus(StationStatus.occupied);
        }
    }

    public String getPayment() {
        return payment;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public List<String> getHistory() {
        return history;
    }



    public void stopCharging(ChargingStation station, int duration) {
        station.stopCharging();
        double cost = station.calculateCost(duration);
        double chargedEnergy = 50.0; // Beispielwert oder Berechnung anpassen, falls nötig
        double tax = 0.2 * cost;
        // Rechnung mit korrekt angeordneten Parametern basierend auf dem Konstruktor
        Invoice invoice = new Invoice(
                "INV" + id,
                station.getId(),
                station.getType().toString(),
                duration,
                chargedEnergy,
                cost,
                tax
        );

        invoices.add(invoice);

        Owner owner = (Owner) App.getAccounts().stream()
                .filter(account -> account instanceof Owner)
                .findFirst().orElse(null);
        if (owner != null) {

        }
        owner.addInvoice(invoice);
        station.setStatus(StationStatus.available);
    }

    @Override
    public List<String> viewPriceOverview() {
        List<String> priceOverview = new ArrayList<>();
        for (Location location : App.getLocations()) {
            String overview = location.getName() + " | AC: " + location.getAcPrice() + "€ | DC: " + location.getDcPrice() + "€";
            priceOverview.add(overview);
        }

        // Optional: Ausgabe zur Überprüfung
        System.out.println("Location | AC Price | DC Price");
        for (String entry : priceOverview) {
            System.out.println(entry);
        }
        return priceOverview;
    }


    public double getBalance() {
        return balance;
    }
    public List<String> viewHistory() {
        return history;
    }
}
