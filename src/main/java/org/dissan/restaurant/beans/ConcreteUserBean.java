package org.dissan.restaurant.beans;

import org.dissan.restaurant.models.ConcreteUser;
import org.dissan.restaurant.models.Role;

public class ConcreteUserBean {

    private ConcreteUser concreteUser;


    public Role getRole(){
        return this.concreteUser.getRole();
    }

    public void setConcreteUser(ConcreteUser concreteUser) {
        this.concreteUser = concreteUser;
    }

}
