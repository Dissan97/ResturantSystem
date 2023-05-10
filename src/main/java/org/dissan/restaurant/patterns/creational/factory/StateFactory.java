package org.dissan.restaurant.patterns.creational.factory;

import org.dissan.restaurant.patterns.behavioral.state.cli.CliState;
import org.dissan.restaurant.patterns.behavioral.state.cli.CliStateEnum;
import org.dissan.restaurant.patterns.behavioral.state.cli.HomeCliState;
import org.dissan.restaurant.patterns.behavioral.state.cli.LoginCliState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StateFactory {
    private StateFactory() {}

    public static @Nullable CliState getInstance(@NotNull CliStateEnum state){
        switch (state){
            case HOME:
                return new HomeCliState();
            case LOGIN:
                return new LoginCliState();
            default:
                return null;
        }
    }
}
