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

    public abstract void topUp(double amount);

    public abstract List<Location> viewAllLocations();

    public abstract List<Invoice> viewInvoices();
}

