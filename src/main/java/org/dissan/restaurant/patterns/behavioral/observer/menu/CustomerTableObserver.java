package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;

import java.util.Objects;

public class CustomerTableObserver extends TableObserver{

    public CustomerTableObserver(String obsName, MenuBean menuBean) {
        super(obsName, menuBean);

    }

    @Override
    public void update(TableStates state) {
        super.setState(state);
        if (Objects.requireNonNull(state) == TableStates.IN_DELIVER) {
            System.out.println(super.getObsName() + " order in deliver");
        }
    }


    @Override
    public void publish(TableStates state) {
        super.getSubject().publish(state);
    }
}
