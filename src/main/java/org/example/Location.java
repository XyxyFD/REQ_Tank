package org.example;

import java.util.List;

public class Location {
    private String name;
    private String city;
    private List<ChargingStation> chargingStations;
    private double acPrice;
    private double dcPrice;

    public Location(String name, String city, List<ChargingStation> chargingStations) {
        this.name = name;
        this.city = city;
        this.chargingStations = chargingStations;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<ChargingStation> getChargingStations() {
        return chargingStations;
    }
    public double getAcPrice() {
        return acPrice;
    }

    public void setAcPrice(double acPrice) {
        this.acPrice = acPrice;
    }

    public double getDcPrice() {
        return dcPrice;
    }

    public void setDcPrice(double dcPrice) {
        this.dcPrice = dcPrice;
    }
}
