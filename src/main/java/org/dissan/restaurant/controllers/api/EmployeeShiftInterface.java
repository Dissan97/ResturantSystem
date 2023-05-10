package org.dissan.restaurant.controllers.api;

import org.dissan.restaurant.beans.EmployeeBean;
import org.dissan.restaurant.beans.ShiftBean;

public interface EmployeeShiftInterface {
    void viewShiftSchedule();
    void requestShiftUpdate(ShiftBean shiftBean, EmployeeBean employeeBean);
}
