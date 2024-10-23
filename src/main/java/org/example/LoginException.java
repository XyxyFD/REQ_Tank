package org.example;

public class LoginException extends Exception {
    public LoginException() {
        super("Login failed: Wrong Email or password.");
    }
}

