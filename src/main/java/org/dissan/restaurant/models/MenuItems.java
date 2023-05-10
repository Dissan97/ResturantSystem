package org.dissan.restaurant.models;

import java.util.List;

public class MenuItems {
    private List<Item> itemList;
    private double bill = 0.0;

    public MenuItems(List<Item> items) {
        this.itemList = items;
    }

    public double getBill() {
        return bill;
    }
    public List<Item> getItems() {
        return this.itemList;
    }
    public void setBill(double bill) {
        this.bill = bill;
    }
}
