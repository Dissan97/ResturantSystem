package org.dissan.restaurant.fxml.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.dissan.restaurant.beans.EmployeeBean;
import org.dissan.restaurant.beans.ShiftBean;
import org.dissan.restaurant.controllers.api.EmployerShiftInterface;
import org.dissan.restaurant.controllers.factories.ShiftManagerFactory;
import org.dissan.restaurant.models.Employee;

import java.text.SimpleDateFormat;

/**
 *
 */
public class EmployerShiftAssignment {

    @FXML
    public DatePicker assignmentCalendar;
    @FXML
    public ListView<Employee> employeesAssignmentList;
    @FXML
    public Button confirmAssignmentButton;
    @FXML
    public Label assignmentEmployerLabel;

    private EmployeeBean employeeBean;

    private EmployerShiftInterface shiftManagerController;

    @FXML
    public void initialize(){
        this.shiftManagerController = ShiftManagerFactory.getShiftEmployerController();
        /*
        TODO HANDLE THIS
        //Employee employeeOne = new Employee("Dissan", "Ahmed");
        //Employee employeeTwo = new Employee("Mario", "Rossi");
        this.employeesAssignmentList.getItems().add(employeeOne);
        this.employeesAssignmentList.getItems().add(employeeTwo);
        this.employeeBean = new EmployeeBean();
        this.employeesAssignmentList.setOnMouseClicked(mouseEvent ->
            this.employeeBean.setEmployee(this.employeesAssignmentList.getSelectionModel().getSelectedItems().get(0))
        );
         */

    }

    @FXML
    public void confirmEmployerButtonHandler() {
        String calendar = this.assignmentCalendar.getEditor().getText();
        if (calendar.isEmpty()){
            //TODO add code
            this.assignmentEmployerLabel.setText("Gello");
        }

        System.out.println(calendar);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");



        ShiftBean shiftBean = new ShiftBean("alana", simpleDateFormat);

        shiftManagerController.assignShift(shiftBean);

    }
}
