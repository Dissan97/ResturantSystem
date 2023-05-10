package org.dissan.restaurant.controllers.factories;

import org.dissan.restaurant.controllers.api.EmployerShiftInterface;
import org.dissan.restaurant.controllers.ShiftManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Creator of shiftManager controller
 */
public class ShiftManagerFactory {

    private ShiftManagerFactory(){}

    @Contract(value = " -> new", pure = true)
    public static @NotNull EmployerShiftInterface getShiftEmployerController(){
        return new ShiftManager();
    }
}
