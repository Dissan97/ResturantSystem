package org.dissan.restaurant.models.dao;

import org.dissan.restaurant.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MenuDao {
    protected static final List<Item> ITEM_LIST = new ArrayList<>();
    public List<Item> getItems() {
        return MenuDao.ITEM_LIST;
    }
}
