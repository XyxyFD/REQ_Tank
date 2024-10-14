package org.example;

import java.util.List;
import java.util.Map;

public class Location {
    private String name;
    private String city;
    private List<ChargingStation> chargingStations;

    public Location(String name, String city, List<ChargingStation> chargingStations) {
        this.name = name;
        this.city = city;
        this.chargingStations = chargingStations;
    }

    public Map<String, Double> displayPrices() {
        // Return prices for AC and DC charging at this location
        return null;
    }

    public List<ChargingStation> getChargingStations() {
        return chargingStations;
    }
}

