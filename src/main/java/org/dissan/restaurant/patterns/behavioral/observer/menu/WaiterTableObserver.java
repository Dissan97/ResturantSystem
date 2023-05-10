package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;

public class WaiterTableObserver extends TableObserver{

    public WaiterTableObserver(String obsName, MenuBean menuBean) {
        super(obsName, menuBean);
    }

    @Override
    public void update(TableStates state) {
        if (state == TableStates.IN_DELIVER){
            //Must be triggered
            System.out.println(super.getObsName() +  ": deliver order to: " + super.getTable().getCod() + " menu:\n" + super.getMenuBean().getMenuInfo());
        }
    }


    @Override
    public void publish(TableStates state) {

    }
}
