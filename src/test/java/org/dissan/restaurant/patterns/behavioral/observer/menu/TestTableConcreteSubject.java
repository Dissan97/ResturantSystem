package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.patterns.creational.factory.TableActors;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTableConcreteSubject {

    private static TableObserverMock mock;

    @BeforeClass
    public static void beforeClass(){
        TestTableConcreteSubject.mock = new TableObserverMock();
    }


    /**
     * Must simulate the interaction between the observers to if they are triggered when necessary
     */
    @Test
    public void observerInteractionTest(){
        int countExpected = 0;
        mock.order();
        countExpected += mock.getState(TableActors.CUSTOMER).equals(mock.getState(TableActors.COOKER)) ? 1 : 0;
        mock.setUpDeliver();
        countExpected += mock.getState(TableActors.WAITER).equals(mock.getState(TableActors.WAITER)) ? 1 : 0;
        assertEquals(2, countExpected);
    }
}
