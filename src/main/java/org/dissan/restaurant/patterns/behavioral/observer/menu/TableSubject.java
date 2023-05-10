package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;

import java.util.ArrayList;
import java.util.List;

public abstract class TableSubject {

    /**
     * Attributes
     */
    private final List<TableObserver> OBSERVERS = new ArrayList<>();
    /**
     * Methods
     */
    abstract void attach(TableObserver obs, MenuBean table);
    abstract void detach(TableObserver obs, MenuBean table);
    abstract void notifyObservers();
    abstract void publish(TableStates states);
}
