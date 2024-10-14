package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();

        // Example usage:
        app.register("customer@example.com", "123456789", "password", "credit card", true); // Registering a Customer
        app.login("customer@example.com", "password"); // Logging in
    }

    // Register a new user as Customer or Owner
    public void register(String email, String phone, String password, String paymentInfo, boolean isCustomer) {
        if (isCustomer) {
            Customer customer = new Customer("Customer Name", email, phone, password, accounts.size() + 1, paymentInfo, 0.0);
            accounts.add(customer);
            System.out.println("Customer registered successfully.");
        } else {
            Owner owner = new Owner("Owner Name", email, phone, password);
            accounts.add(owner);
            System.out.println("Owner registered successfully.");
        }
    }

    // Login method to authenticate users by email/username and password
    public Account login(String usernameOrId, String password) {
        for (Account account : accounts) {
            if ((account.email.equals(usernameOrId) || account.phoneNumber.equals(usernameOrId)) && account.password.equals(password)) {
                System.out.println("Login successful for: " + account.name);
                return account;
            }
        }
        System.out.println("Login failed: Incorrect username or password.");
        return null;
    }
}
