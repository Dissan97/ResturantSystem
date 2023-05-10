package org.dissan.restaurant.patterns.creational.factory;

import org.dissan.restaurant.models.TableMock;
import org.dissan.restaurant.patterns.behavioral.observer.menu.CookerTableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.CustomerTableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.TableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.WaiterTableObserver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTableObserverFactory {

    /**
     * This test must be updated if there are new table actors and so new TableObserver
     */
    @Test
    public void goodInstanceTest(){

        int goodCounter = 0;
        boolean goodInstance;
        TableObserver observer;

        for (TableActors actor:
             TableActors.values()) {

            observer = TableObserverFactory.getObserver(actor, TableMock.getTableTestBean());

            switch (actor){
                case COOKER:
                    goodInstance = observer instanceof CookerTableObserver;
                    break;
                case WAITER:
                    goodInstance = observer instanceof WaiterTableObserver;
                    break;
                case CUSTOMER:
                    goodInstance = observer instanceof CustomerTableObserver;
                    break;
                default:
                    goodInstance = false;
                    break;
            }

            goodCounter += goodInstance ? 1 : 0;
        }

        assertEquals(TableActors.values().length, goodCounter);
    }
}
