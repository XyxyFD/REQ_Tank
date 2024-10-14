package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Owner extends Account {
    private Map<String, Map<String, Double>> locationPrices = new HashMap<>();

    public Owner(String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber, password);
    }

    @Override
    public void topUp(double amount) {
        // Implementation specific to Owner
    }

    @Override
    public List<Location> viewAllLocations() {
        // Logik, um alle Locations zu erhalten
        return new ArrayList<>(); // Beispiel: Rückgabe einer leeren Liste als Platzhalter
    }

    @Override
    public List<Invoice> viewInvoices() {
        // Implementation to view all invoices
        return null;
    }

    public void setPrices(String location, Map<String, Double> prices) {
        locationPrices.put(location, prices);
    }
    public Map<String, Double> getPrices(String location) {
        return locationPrices.getOrDefault(location, new HashMap<>());
    }
}
