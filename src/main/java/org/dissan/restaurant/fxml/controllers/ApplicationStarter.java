package org.dissan.restaurant.fxml.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class ApplicationStarter extends Application {

    public static final int WIDHT = 1024;
    public static final int HEIGHT = 720;

    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setTitle("RESTURANT MANAGER");
        FXMLLoader loader = new FXMLLoader(ApplicationStarter.class.getResource("session.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    //TODO IMPLEMENTS A SESSION MANAGER THAT WILL LOAD A NEW WINDOW TO SIMULATE USER INTERACTION AND IMPLEMENTS PATTERN OBSERVER

    public static void main(String[] args) throws ParseException {
        launch(args);
    }

    @FXML
    public void newSession() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("LOGIN");
        FXMLLoader loader = new FXMLLoader(ApplicationStarter.class.getResource("login_view.fxml"));
        Scene scene = new Scene(loader.load(), WIDHT, HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
