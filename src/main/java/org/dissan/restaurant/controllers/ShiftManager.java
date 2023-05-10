package org.dissan.restaurant.controllers;

import org.dissan.restaurant.beans.EmployeeBean;
import org.dissan.restaurant.beans.ShiftBean;
import org.dissan.restaurant.controllers.api.EmployeeShiftInterface;
import org.dissan.restaurant.controllers.api.EmployerShiftInterface;
import org.dissan.restaurant.models.Employee;
import org.dissan.restaurant.models.ShiftSchedule;

import java.util.List;

public class ShiftManager implements EmployerShiftInterface, EmployeeShiftInterface {

    private List<EmployeeBean> employeeBeanList;
    private List<Employee> employees;

    @Override
    public void assignShift(ShiftBean shiftBean) {
        ShiftSchedule shiftSchedule = new ShiftSchedule();
        //todo Control on date for shiftScheduleDate
        String shiftDate = shiftBean.getShiftDate();
        Employee employee = shiftBean.getEmployee();
        controlShift(shiftDate, employee);
        shiftSchedule.setDate(shiftDate);
        shiftSchedule.setEmployee(shiftBean.getEmployee());
    }
    //todo add some exception
    private void controlShift(String shiftDate, Employee employee) {
    }

    @Override
    public void viewShiftSchedule() {

    }

    @Override
    public void requestShiftUpdate(ShiftBean shiftBean, EmployeeBean employeeBean) {

    }
}
