package org.dissan.restaurant.controllers;

import org.dissan.restaurant.beans.ConcreteUserBean;
import org.dissan.restaurant.exceptions.LoginException;
import org.dissan.restaurant.models.Manager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LoginTest {

    private static Logger logger;

    @BeforeClass
    public static void init(){
        logger = Logger.getLogger("LOGIN TEST");
    }
    @Test
    public void signInTestRoleManager(){
        boolean testPassed = false;
        logger.info("LOGIN TEST");
        Login login = new Login();
        ConcreteUserBean concreteUserBean = login.getUserBean();

        try {
            login.signIn("TEST_MANAGER", "password");
            if (concreteUserBean.getRole() instanceof Manager){
                testPassed = true;
            }
        } catch (IOException | LoginException e) {
            logger.log(Level.WARNING, "LOGIN FAILED");
        }
        assertTrue(testPassed);
    }
}
