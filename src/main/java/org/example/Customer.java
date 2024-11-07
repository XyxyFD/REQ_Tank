package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Account {
    private int id;
    private String payment;
    private double balance;
    private List<Invoice> invoices = new ArrayList<>();
    private List<Location> compareLocations = new ArrayList<>();
    private List<String> history = new ArrayList<>();

    public Customer(String name, String email, String phoneNumber, String password, int id, double balance) {
        super(name, email, phoneNumber, password);
        this.id = id;
        this.balance = balance;
        this.payment = "NO_PAYMENT_INFO";
    }
    public Customer(String name, String email, String phoneNumber, String password, int id, double balance, String payment) {
        super(name, email, phoneNumber, password);
        this.id = id;
        this.balance = balance;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }


    public void topUp(double amount) throws TopUpException {
        if ("NO_PAYMENT_INFO".equals(this.getPayment())) {
            throw new TopUpException("Cannot top up: No payment information provided.");
        }
        if (this.balance + amount > 5000) {
            throw new TopUpException("Balance cannot exceed 5000 euros.");
        }
        if(amount < 10){
            throw new TopUpException("You have to top-up at least 10 Euros");
        }
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

    public void setPayment(String payment) {
        this.payment = payment;
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


    public List<String> viewHistory() throws Exception {
        if(history.isEmpty()){
            throw new Exception("You do not have a history yet");
        }
        return history;
    }
    public void startCharging(ChargingStation selectedStation) throws StartStationException {
        if (selectedStation.getStatus() == StationStatus.occupied) {
            throw new StartStationException("Charging station is currently occupied.");
        } else if (selectedStation.getStatus() == StationStatus.outOfOrder) {
            throw new StartStationException("Charging station is out of order.");
        }
       selectedStation.setStatus(StationStatus.occupied);
    }
    public void addLocationToCompare(Location location){
        compareLocations.add(location);
    }
    public void comparePrices() throws Exception{
        if(compareLocations.isEmpty()){
            throw new Exception("You have not selected a station");
        }
        for (Location loc:
                compareLocations) {
            System.out.println("Name: " + loc.getName());
            System.out.println("DC Price : " + loc.getDcPrice());
            System.out.println("AC Price : " + loc.getAcPrice());
            System.out.println("...........................................................");
        }
    }
    public void addHistory(String history){
        this.history.add(history);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
