module ResturantSystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires java.logging;
    requires com.google.gson;
    requires java.desktop;

    exports org.dissan.restaurant.controllers;
    exports org.dissan.restaurant.fxml.controllers;
    exports org.dissan.restaurant.models;
    exports org.dissan.restaurant.beans;
    exports org.dissan.restaurant.exceptions;
    exports org.dissan.restaurant.models.dao;
    exports org.dissan.restaurant.patterns.creational.factory;
    exports org.dissan.restaurant.patterns.behavioral.observer.menu;
    exports org.dissan.restaurant.patterns.behavioral.state.cli;

    opens org.dissan.restaurant.fxml.controllers to javafx.fxml;
    exports org.dissan.restaurant.controllers.api;
}