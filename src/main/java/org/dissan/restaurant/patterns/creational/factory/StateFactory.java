package org.dissan.restaurant.patterns.creational.factory;

import org.dissan.restaurant.beans.UserBean;
import org.dissan.restaurant.patterns.behavioral.state.cli.*;
import org.dissan.restaurant.patterns.behavioral.state.cli.exceptions.CliUiException;
import org.jetbrains.annotations.NotNull;

public class StateFactory {
    private StateFactory() {}

    private static final String UI_MESSAGE = "ui does not exist";
    public static @NotNull CliState getInstance(@NotNull CliStateEnum state) throws CliUiException {
        switch (state){
            case HOME:
                return new HomeCliState();
            case LOGIN:
                return new LoginCliState();
            case ASSIGN_SHIFT:
                return new AssignShiftCliState();
            default:
                throw new CliUiException(UI_MESSAGE);
        }
    }

    public static @NotNull CliState getInstance(@NotNull CliStateEnum cliStateEnum, UserBean bean) throws CliUiException {
        switch (cliStateEnum){
            case ATTENDANT:
                return new AttendantHomeCliState(bean);
            case COOKER:
            case MANAGER:
                return new ManagerHomeCliState(bean);
            case HOME:
            case LOGIN:
                return getInstance(cliStateEnum);
            case ASSIGN_SHIFT:
            default:
                throw new CliUiException(UI_MESSAGE);
        }
    }
}
