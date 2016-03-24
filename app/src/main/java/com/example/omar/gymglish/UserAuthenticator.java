package com.example.omar.gymglish;

/**
 * Created by Omar on 24/03/2016.
 */
public class UserAuthenticator {

    private static final String LOGIN = "gymglish123";
    private static final String PASSWORD = "gymglish123";

    public boolean authenticate(String login, String password) {
        return LOGIN.equals(login) && PASSWORD.equals(password);
    }
}
