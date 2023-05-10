package org.dissan.restaurant.exceptions;

public class InvalidCreditCard extends Exception{

    public InvalidCreditCard(String msg) {
        super(msg);
    }

    public InvalidCreditCard(int i) {

    }
}
