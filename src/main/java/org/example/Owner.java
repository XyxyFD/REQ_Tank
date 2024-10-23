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
    public List<ChargingStation> viewAllStations() {
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


    public void setACPrice(Location location, double acPrice) throws SetChargingPricesException {
        validatePrice(acPrice);
        location.setAcPrice(acPrice);
    }
    public void setDCPrice(Location location, double dcPrice) throws SetChargingPricesException {
        validatePrice(dcPrice);
        location.setDcPrice(dcPrice);
    }
    private void validatePrice(double price) throws SetChargingPricesException {
        if (price < 0) {
            throw new SetChargingPricesException("Charging price cannot be negative");
        }
        // Simpler Dummy-Wert für Durchschnittspreis-Validierung, kann angepasst werden
        double averagePrice = 2.5;
        if (price > 10 * averagePrice) {
            throw new SetChargingPricesException("Charging price cannot be more than 1000% over the average.");
        }
    }

    public Map<String, Double> getPrices(String location) {
        return locationPrices.getOrDefault(location, new HashMap<>());
    }

    public double getAverageACPrice(){
        return 2.5;
    }
    public double getAverageDCPrice(){
        return 2.5;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
    public List<Location> viewAllLocations() {
        return App.getLocations();
    }

}
