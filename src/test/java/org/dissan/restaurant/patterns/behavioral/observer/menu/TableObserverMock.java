package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.models.TableMock;
import org.dissan.restaurant.patterns.creational.factory.TableActors;
import org.dissan.restaurant.patterns.creational.factory.TableObserverFactory;
import org.jetbrains.annotations.NotNull;

public class TableObserverMock {

    private final TableObserver cooker;
    private final TableObserver customer;
    private final TableObserver waiter;

    public TableObserverMock() {
        this.cooker = TableObserverFactory.getObserver(TableActors.COOKER, TableMock.getTableTestBean());
        this.customer = TableObserverFactory.getObserver(TableActors.CUSTOMER, TableMock.getTableTestBean());
        this.waiter = TableObserverFactory.getObserver(TableActors.WAITER, TableMock.getTableTestBean());
    }

    public void order(){
        this.customer.publish(TableStates.NEW_ORDER);
    }

    public void viewOrder(){

    }

    public void setUpDeliver(){
        this.cooker.publish(TableStates.IN_DELIVER);
    }

    public TableStates getState(@NotNull TableActors actor){
        switch (actor){
            case COOKER:
                return this.cooker.getStates();
            case CUSTOMER:
                return this.customer.getStates();
            case WAITER:
                return this.waiter.getStates();
            default:
                return null;
        }
    }

}
