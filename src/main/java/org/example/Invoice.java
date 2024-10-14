package org.example;

public class Invoice {
    private String invoiceNumber;
    private String locationName;
    private String chargingPoint;
    private String chargingMode;
    private int duration;
    private double chargedEnergy;
    private double price;

    public Invoice(String invoiceNumber, String locationName, String chargingPoint, String chargingMode, int duration, double chargedEnergy, double price) {
        this.invoiceNumber = invoiceNumber;
        this.locationName = locationName;
        this.chargingPoint = chargingPoint;
        this.chargingMode = chargingMode;
        this.duration = duration;
        this.chargedEnergy = chargedEnergy;
        this.price = price;
    }

    public void generateInvoice() {
        // Logic to generate invoice
    }

    public void displayInvoice() {
        // Logic to display invoice details
    }
}

