package org.dissan.restaurant.controllers;

import org.dissan.restaurant.models.ConcreteUser;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to simulate the interaction between two actors
 */

public class SessionManager {

    private static int numOfUser = 0;
    private static final List<ConcreteUser> userList = new ArrayList<>();
    private SessionManager(){}

    public static void newUser(ConcreteUser concreteUser){
        numOfUser ++;
        userList.add(concreteUser);
    }

    public static void userGone(ConcreteUser concreteUser){
        if (numOfUser > 0) {
            userList.remove(concreteUser);
            numOfUser--;

        }
    }

}
