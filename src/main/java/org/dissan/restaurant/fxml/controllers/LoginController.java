package org.dissan.restaurant.fxml.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import org.dissan.restaurant.beans.ConcreteUserBean;
import org.dissan.restaurant.controllers.Login;

/**
 * Login graphics controller
 */
public class LoginController {

    @FXML
    public TextArea username;

    @FXML
    public PasswordField password;

    private ConcreteUserBean userBean;
    private Login loginController;

    @FXML
    public void initialize() {
        this.loginController = new Login();
        this.userBean = this.loginController.getUserBean();
    }


    @FXML
    public void signIn() {
    }
}
