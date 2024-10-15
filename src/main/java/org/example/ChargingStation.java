package org.example;

public class ChargingStation {
    private String id;
    private StationType type;
    private StationStatus status;

    public ChargingStation(String id, StationType type, StationStatus status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public void startCharging() {
        // Logic to start charging
        this.status = StationStatus.occupied;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    public void stopCharging() {
        // Logic to stop charging
        this.status = StationStatus.available;
    }

    public String checkStatus() {
        return status.name();
    }

    public double calculateCost(int duration) {
        // Logic to calculate cost based on duration and type
        return 0.0;
    }

    public String getId() {
        return id;
    }

    public StationType getType() {
        return type;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setType(StationType stationType) {
        this.type = stationType;
    }
}

