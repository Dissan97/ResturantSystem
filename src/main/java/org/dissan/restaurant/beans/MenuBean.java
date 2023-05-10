package org.dissan.restaurant.beans;

import org.dissan.restaurant.models.Item;
import org.dissan.restaurant.models.MenuItems;
import org.dissan.restaurant.models.Table;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class MenuBean implements MenuBeanApi {

    private MenuItems menu;
    private Table table;
    public MenuBean() {
    }

    public MenuBean(@NotNull MenuItems menu) {
        this.menu = menu;
    }

    public MenuBean(Table table, List<Item> items) {
        this.table = table;
        this.menu = new MenuItems(items);
    }

    public double getBill(){
        return this.menu.getBill();
    }

    public @NotNull String getMenuInfo(){
        List<Item> itemList = this.menu.getItems();
        StringBuilder builder = new StringBuilder();
        for (Item i:
             itemList) {
            builder.append("name:").append(i.getName()).append(",price:").append(i.getPrice()).append('\n');
        }

        return builder.toString();
    }

    public List<Item> getItemList(){
        return this.menu.getItems();
    }

    public void setBill(double bill) {
        this.menu.setBill(bill);
    }

    public Table getTable() {
        return table;
    }
}
