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
    public List<ChargingStation> viewAllLocations() {
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
        // Logik zur Auswahl einer Ladestation
    }

    public void startCharging(ChargingStation station) {
        station.startCharging();
    }

    public void stopCharging(ChargingStation station, int duration) {
        station.stopCharging();
        double cost = station.calculateCost(duration);

        // Rechnung mit korrekt angeordneten Parametern basierend auf dem Konstruktor
        Invoice invoice = new Invoice(
                "INV" + id,              // invoiceNumber
                station.getId(),         // locationName
                station.getId(),         // chargingPoint
                station.getType().toString(), // chargingMode
                duration,                // duration
                50.0,                    // Beispielwert für chargedEnergy
                cost                     // price
        );

        invoices.add(invoice);

        Owner owner = (Owner) App.getAccounts().stream()
                .filter(account -> account instanceof Owner)
                .findFirst().orElse(null);
        if (owner != null) {
            owner.addInvoice(invoice);
        }
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
