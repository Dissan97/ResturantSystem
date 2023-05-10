package org.dissan.restaurant.beans;

import org.jetbrains.annotations.NotNull;

public interface MenuBeanApi {
    @NotNull String getMenuInfo();
    double getBill();
}
