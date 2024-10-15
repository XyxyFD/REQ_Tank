package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Owner extends Account {
    private Map<String, Map<String, Double>> locationPrices = new HashMap<>();
    private List<Invoice> invoices = new ArrayList<>();

    public Owner(String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber, password);
    }

    @Override
    public void topUp(double amount) {
        // Logik spezifisch für den Owner
    }

    @Override
    public List<ChargingStation> viewAllLocations() {
        List<ChargingStation> allStations = new ArrayList<>();
        for (Location location : App.getLocations()) {
            allStations.addAll(location.getChargingStations());
        }

        System.out.println("Location Name | Station ID | Type | Status");
        for (Location location : App.getLocations()) {
            for (ChargingStation station : location.getChargingStations()) {
                System.out.println(location.getName() + " | " + station.getId() + " | " + station.getType() + " | " + station.getStatus());
            }
        }
        return allStations;
    }

    @Override
    public List<Invoice> viewInvoices() {
        //TODO GETTER einfügen damit das printen funktioniert
        /*System.out.println("Invoice Number | Location | Charging Point | Mode | Duration | Energy | Price");
        for (Invoice invoice : invoices) {
            System.out.println(invoice.getInvoiceNumber() + " | " + invoice.getLocationName() + " | " + invoice.getChargingPoint() + " | " +
                    invoice.getChargingMode() + " | " + invoice.getDuration() + " | " + invoice.getChargedEnergy() + " | " + invoice.getPrice());
        }

         */
        return invoices;
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


    public void setPrices(Location location, double acPrice, double dcPrice) {
        location.setAcPrice(acPrice);
        location.setDcPrice(dcPrice);
    }

    public Map<String, Double> getPrices(String location) {
        return locationPrices.getOrDefault(location, new HashMap<>());
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}
