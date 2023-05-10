package org.dissan.restaurant.patterns.behavioral.observer.menu;

import org.dissan.restaurant.beans.MenuBean;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * May use some factory to get Subject foreach Table...
 */
public class TableConcreteSubject extends TableSubject{

    private static TableConcreteSubject tableConcreteSubject = null;

    private final Map<String, List<TableObserver>> tableObserverMap = new HashMap<>();

    private TableConcreteSubject(){}

    @Override
    void attach(TableObserver obs, @NotNull MenuBean menuBean) {
        String key = menuBean.getTable().getCod();
        if (this.tableObserverMap.containsKey(key)){
            tableObserverMap.get(key).add(obs);
        }else {
            List<TableObserver> tableObservers = new ArrayList<>();
            tableObservers.add(obs);
            this.tableObserverMap.put(key, tableObservers);
        }
    }

    @Override
    void detach(TableObserver obs, @NotNull MenuBean menuBean) {
        String key = menuBean.getTable().getCod();
        if (this.tableObserverMap.containsKey(key)){
            this.tableObserverMap.get(key).remove(obs);
        }
    }


    @Override
    void notifyObservers() {

    }

    @Override
    void publish(TableStates state) {
        Set<String> keys = this.tableObserverMap.keySet();
        for (String k:
             keys) {
            for (TableObserver obs:
                 this.tableObserverMap.get(k)) {
                System.out.println("publish: " + obs.getObsName());
                obs.update(state);
            }
        }
    }

    public static TableConcreteSubject getInstance(){
        if (TableConcreteSubject.tableConcreteSubject == null){
            TableConcreteSubject.tableConcreteSubject = new TableConcreteSubject();
        }
        return TableConcreteSubject.tableConcreteSubject;
    }

}
