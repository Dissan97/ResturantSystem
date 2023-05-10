package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;
import org.dissan.restaurant.models.Table;

public abstract class TableObserver {
    private static final String OBS = "OBSERVER{";
    private String obsName;
    private TableStates states = TableStates.IDLE;
    private TableSubject subject;
    private final MenuBean menuBean;

    protected TableObserver(String obsName, MenuBean menuBean) {
        this.setObsName(obsName);
        this.menuBean = menuBean;
        setSubject(TableConcreteSubject.getInstance());
        getSubject().attach(this, menuBean);
    }

    public abstract void update(TableStates state);
    public abstract void publish(TableStates state);
    public String getObsName() {
        return obsName;
    }
    protected void setObsName(String obsName) {
        this.obsName = TableObserver.OBS + obsName +'}';
    }

    public void setSubject(TableSubject subject) {
        this.subject = subject;
    }

    protected TableSubject getSubject() {
        return this.subject;
    }

    protected Table getTable() {
        return this.menuBean.getTable();
    }

    protected void setState(TableStates state) {
        this.states = state;
    }

    public TableStates getStates() {
        return states;
    }

    public MenuBean getMenuBean() {
        return menuBean;
    }
}
