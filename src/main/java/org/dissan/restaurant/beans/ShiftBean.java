package org.dissan.restaurant.beans;

import org.dissan.restaurant.models.Employee;

import java.text.SimpleDateFormat;

public class ShiftBean {

    private SimpleDateFormat shiftDate;
    private EmployeeBean employeeBean;

    public ShiftBean(String employerCode, SimpleDateFormat shiftDate) {
        this.shiftDate = shiftDate;
        this.employeeBean = new EmployeeBean();

    }

    public String getShiftDate() {
        return this.shiftDate.toPattern();
    }

    public Employee getEmployee() {
        return this.employeeBean.getEmployee();
    }
}
