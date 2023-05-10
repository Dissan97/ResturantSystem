package org.dissan.restaurant.patterns.creational.factory;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;
import org.dissan.restaurant.patterns.behavioral.observer.menu.CookerTableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.CustomerTableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.TableObserver;
import org.dissan.restaurant.patterns.behavioral.observer.menu.WaiterTableObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Factory class Creator:
 * {
 *     CustomerTableObserver,
 *     CookerTableObserver,
 *     WaiterTableObserver
 * }
 */
public class TableObserverFactory {

    private TableObserverFactory(){}

    public static @Nullable TableObserver getObserver(@NotNull TableActors actor, MenuBean tableBean){
        switch (actor){
            case CUSTOMER:
                return new CustomerTableObserver(actor.name(), tableBean);
            case COOKER:
                return new CookerTableObserver(actor.name(), tableBean);
            case WAITER:
                return new WaiterTableObserver(actor.name(), tableBean);
            default:
                return null;
        }
    }
}
