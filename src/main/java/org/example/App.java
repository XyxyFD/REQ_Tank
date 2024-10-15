package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static List<Account> accounts = new ArrayList<>();
    private static List<Location> locations = new ArrayList<>();

    public App() {
        initialize();
    }

    void initialize() {
        // Initialisierung von Locations
        List<ChargingStation> location1Stations = new ArrayList<>();
        location1Stations.add(new ChargingStation("CS1", StationType.AC, StationStatus.available));
        location1Stations.add(new ChargingStation("CS2", StationType.DC, StationStatus.occupied));
        Location location1 = new Location("Main Station", "Vienna", location1Stations);
        location1.setAcPrice(3.0);
        location1.setDcPrice(4.0);

        List<ChargingStation> location2Stations = new ArrayList<>();
        location2Stations.add(new ChargingStation("CS3", StationType.AC, StationStatus.available));
        location2Stations.add(new ChargingStation("CS4", StationType.DC, StationStatus.outOfOrder));
        Location location2 = new Location("Central Park", "Salzburg", location2Stations);
        location2.setAcPrice(3.5);
        location2.setDcPrice(4.5);

        locations.add(location1);
        locations.add(location2);

        // Initialisierung von Accounts
        Owner owner = new Owner("Owner Name", "owner@example.com", "111111111", "password");
        accounts.add(owner);

        Customer customer1 = new Customer("Customer1", "customer1@example.com", "222222222", "password", 1, "credit card", 0.0);
        Customer customer2 = new Customer("Customer2", "customer2@example.com", "333333333", "password", 2, "debit card", 0.0);
        accounts.add(customer1);
        accounts.add(customer2);

        Invoice invoice1 = new Invoice("INV001", "CS1", "AC", 30, 50.0, 20.0, 10.0);
        Invoice invoice2 = new Invoice("INV002", "CS2", "DC", 45, 60.0, 25.0, 15.0);
        Invoice invoice3 = new Invoice("INV003", "CS3", "AC", 60, 75.0, 30.0, 20.0);

        customer1.viewInvoices().add(invoice1);
        customer1.viewInvoices().add(invoice2);
        customer2.viewInvoices().add(invoice3);

        owner.addInvoice(invoice1);
        owner.addInvoice(invoice2);
        owner.addInvoice(invoice3);
        customer1.viewHistory().add("Duration: 20 min, Cost: 5.0€");
        customer1.viewHistory().add("Duration: 30 min, Cost: 7.5€");

        customer2.viewHistory().add("Duration: 25 min, Cost: 6.0€");
        customer2.viewHistory().add("Duration: 35 min, Cost: 8.0€");
    }

    public static List<Location> getLocations() {
        return locations;
    }

    public static List<Account> getAccounts() {
        return accounts;
    }
    public static void main(String[] args) {
        App app = new App();

        // Beispielverwendung:
        app.register("customer@example.com", "123456789", "password", "credit card"); // Customer registrieren
        app.login("customer@example.com", "password"); // Einloggen
    }

    // Registriere neuen Benutzer als Customer oder Owner
    public Customer register(String email, String phone, String password, String paymentInfo) {
        // Erstellt und fügt einen neuen Kunden zur Accountliste hinzu
        Customer customer = new Customer("Customer Name", email, phone, password, accounts.size() + 1, paymentInfo, 0.0);
        accounts.add(customer);
        System.out.println("Customer erfolgreich registriert.");
        return customer;
    }


    // Login-Methode zur Authentifizierung von Nutzern
    public Account login(String usernameOrId, String password) {
        for (Account account : accounts) {
            if ((account.email.equals(usernameOrId) || account.phoneNumber.equals(usernameOrId)) && account.password.equals(password)) {
                System.out.println("Login erfolgreich für: " + account.name);
                return account;
            }
        }
        System.out.println("Login fehlgeschlagen: Benutzername oder Passwort falsch.");
        return null;
    }


}
