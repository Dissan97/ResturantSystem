package org.dissan.restaurant.exceptions;

public class LoginException extends Exception{

    public static final String USER_NOT_FOUND = "USER NOT FOUND";
    public static final String BAD_CREDENTIAL = "BAD CREDENTIAL";
    public LoginException() {
        super("LoggedUser not found");
    }

    public LoginException(String message) {
        super(message);
    }
}
