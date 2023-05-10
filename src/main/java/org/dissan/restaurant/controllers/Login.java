package org.dissan.restaurant.controllers;

import org.dissan.restaurant.beans.ConcreteUserBean;
import org.dissan.restaurant.controllers.api.UserLoginController;
import org.dissan.restaurant.models.ConcreteUser;
import org.dissan.restaurant.models.dao.UserDao;
import org.dissan.restaurant.exceptions.LoginException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Login implements UserLoginController {
    private final ConcreteUserBean concreteUserBean;

    public Login(){
        this.concreteUserBean = new ConcreteUserBean();
    }

    public void signIn(String username, String password) throws IOException, LoginException {
        UserDao userDao = new UserDao();
        //Getting user by name
        ConcreteUser concreteUser = userDao.getUserByUsername(username);

        if (!concreteUser.getPassword().equals(password)){
            throw new LoginException(LoginException.BAD_CREDENTIAL);
        }
        this.concreteUserBean.setConcreteUser(concreteUser);
    }

    @Override
    @NotNull
    public ConcreteUserBean getUserBean() {
        return this.concreteUserBean;
    }

    @Override
    public void signUp(ConcreteUserBean userBean) {

    }
}
