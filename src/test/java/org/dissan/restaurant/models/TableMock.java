package org.dissan.restaurant.models;

import org.dissan.restaurant.beans.MenuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * SIMULATED TABLE FOR TEST CASE
 * INFORMATION EXPERT OF TABLE
 */
public class TableMock {
    private final static Table TABLE = new Table("TEST_TABLE", 4, new Waiter());
    private final static List<Item> ITEM_LIST = new ArrayList<>();
    private final static MenuBean MENU_BEAN = new MenuBean(TABLE, ITEM_LIST);
    
    public static MenuBean getTableTestBean(){
        if (TableMock.ITEM_LIST.size() == 0){
            String testItem = "testItem";
            for (int i = 1; i <= TableMock.TABLE.getCustomersNumber(); i++){
                TableMock.ITEM_LIST.add(new Item(testItem + i, (40.0 + i) / (2.0 * i)));
            }
        }
        return TableMock.MENU_BEAN;
    }
    
}
