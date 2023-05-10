package org.dissan.restaurant.patterns.behavioral.state.cli;

import org.dissan.restaurant.patterns.creational.factory.StateFactory;

import javax.swing.*;
import java.util.Objects;

public class StateClient {


    public void start(){
        Objects.requireNonNull(StateFactory.getInstance(CliStateEnum.HOME)).updateUi();
    }

    public static void main(String...arg){
        StateClient client = new StateClient();
        client.start();
    }
}