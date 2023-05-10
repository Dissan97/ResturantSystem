package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;

public class CookerTableObserver extends TableObserver{
    public CookerTableObserver(String obsName, MenuBean menuBean) {
        super(obsName, menuBean);
    }

    @Override
    public void update(TableStates state) {
        super.setState(state);
        if (state == TableStates.NEW_ORDER){
            //Must be triggered
            System.out.println(super.getObsName() +  ": THERE IS A NEW ORDER FROM " + super.getTable().getCod() + " menu:\n" + super.getMenuBean().getMenuInfo());
        }
    }


    @Override
    public void publish(TableStates state) {
        super.getSubject().publish(TableStates.IN_DELIVER);
    }
}
