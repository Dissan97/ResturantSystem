package org.dissan.restaurant.models;

public class ShiftSchedule {

    private String shiftDate;
    private Employee employee;

    public void setDate(String shiftDate) {
        this.shiftDate = shiftDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
