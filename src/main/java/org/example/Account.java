package org.example;

import java.util.List;

public abstract class Account {
    public String name;
    public String email;
    public String phoneNumber;
    public String password;

    public Account(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public abstract List<ChargingStation> viewAllStations();
    public abstract List<Invoice> viewInvoices();
    public abstract List<String> viewPriceOverview();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
