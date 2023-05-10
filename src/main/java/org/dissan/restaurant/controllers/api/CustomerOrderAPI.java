package org.dissan.restaurant.controllers.api;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;

public interface CustomerOrderAPI {
    void pay();
    MenuBean getMenuBean();
    Table getTable();
}
