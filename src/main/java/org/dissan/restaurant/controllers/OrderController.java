package org.dissan.restaurant.controllers;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.controllers.api.AttendantOrderAPI;
import org.dissan.restaurant.controllers.api.CookerOrderAPI;
import org.dissan.restaurant.controllers.api.CustomerOrderAPI;
import org.dissan.restaurant.models.Item;
import org.dissan.restaurant.models.Table;
import org.dissan.restaurant.models.dao.MenuDao;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderController implements CustomerOrderAPI, CookerOrderAPI, AttendantOrderAPI {

    private final MenuBean menuBean;
    private MenuDao menuDao;

    public OrderController(Table table, @NotNull MenuDao menuDao) {
        this.menuDao = menuDao;
        List<Item> items = menuDao.getItems();
        this.menuBean = new MenuBean(table, items);
    }

    public OrderController(Table table) {
        this(table, new MenuDao());
    }

    @Override
    public void pay(){
        // method used to pay the bill
    }

    @Override
    public MenuBean getMenuBean() {
       return this.menuBean;
    }

    @Override
    public Table getTable() {
        return this.menuBean.getTable();
    }

    public void calculateBilling(){
        List<Item> itemList = menuBean.getItemList();
        double bill = 0;
        for (Item i:
             itemList) {
            bill += i.getPrice();
        }
        this.menuBean.setBill(bill);
    }


    @Override
    public void isThereDelivery() {

    }

    @Override
    public void delivered(Table table) {

    }

    @Override
    public void orderReady(Table table) {

    }
}
