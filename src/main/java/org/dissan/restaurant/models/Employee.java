package org.dissan.restaurant.models;

abstract public class Employee extends Role {

    private String employeeCode;

    public Employee(String name, String surname) {

    }

    public Employee() {

    }

    public String getEmployeeCode() {
        return employeeCode;
    }
}
