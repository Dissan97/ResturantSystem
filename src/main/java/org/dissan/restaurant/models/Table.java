package org.dissan.restaurant.models;

public class Table {
    private String cod;
    private final int nCustomers;
    private Waiter waiter;

    public Table(String cod, int customers, Waiter waiter) {
        this.cod = cod;
        this.nCustomers = customers;
        this.waiter = waiter;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCustomersNumber() {
        return nCustomers;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    
}
