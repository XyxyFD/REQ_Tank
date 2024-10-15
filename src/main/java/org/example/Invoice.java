package org.example;

public class Invoice {
    private String invoiceId;
    private String stationId;
    private String type;
    private int duration;
    private double energyConsumed;
    private double totalCost;
    private double tax;

    public Invoice(String invoiceId, String stationId, String type, int duration, double energyConsumed, double totalCost, double tax) {
        this.invoiceId = invoiceId;
        this.stationId = stationId;
        this.type = type;
        this.duration = duration;
        this.energyConsumed = energyConsumed;
        this.totalCost = totalCost;
        this.tax = tax;
    }

    public String getInvoiceId() { return invoiceId; }
    public String getStationId() { return stationId; }
    public String getType() { return type; }
    public int getDuration() { return duration; }
    public double getEnergyConsumed() { return energyConsumed; }
    public double getTotalCost() { return totalCost; }
    public double getTax() { return tax; }
}

