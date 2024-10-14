package org.example;

import java.util.List;

public class Customer extends Account {
    private int id;
    private String payment;
    private double balance;

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
    public List<Location> viewAllLocations() {
        // View available locations for charging stations
        return null;
    }

    @Override
    public List<Invoice> viewInvoices() {
        // View customer invoices
        return null;
    }

    public void selectChargingStation(ChargingStation station) {
        // Select a charging station
    }

    public void startCharging() {
        // Start charging at the selected station
    }

    public void stopCharging() {
        // Stop charging
    }

    public void viewPriceOverview() {
        // View price overview for charging stations
    }

    public double getBalance() {
        return balance;
    }


    // Method to check if the customer is logged in

}
