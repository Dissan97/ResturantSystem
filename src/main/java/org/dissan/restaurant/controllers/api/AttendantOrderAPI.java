package org.dissan.restaurant.controllers.api;

import org.dissan.restaurant.models.Table;

public interface AttendantOrderAPI {
    void isThereDelivery();
    void delivered(Table table);
}
