package org.dissan.restaurant.controllers.api;

import org.dissan.restaurant.beans.ConcreteUserBean;
import org.dissan.restaurant.exceptions.LoginException;

import java.io.IOException;

public interface UserLoginController {

    void signIn(String username, String password) throws IOException, LoginException;
    ConcreteUserBean getUserBean();
    void signUp(ConcreteUserBean userBean);
}
