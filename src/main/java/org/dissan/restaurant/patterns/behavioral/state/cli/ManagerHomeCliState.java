package org.dissan.restaurant.patterns.behavioral.state.cli;

import org.dissan.restaurant.beans.UserBean;
import org.dissan.restaurant.beans.api.ShiftScheduleBeanApi;
import org.dissan.restaurant.controllers.ShiftManager;
import org.jetbrains.annotations.NotNull;

public class ManagerHomeCliState extends AccountHomeCliState{

    private ShiftManager shiftManager;
    private final ShiftScheduleBeanApi scheduleBean;
    public ManagerHomeCliState(@NotNull UserBean bean) {
        super(ManagerHomeCliState.class.getSimpleName(),bean);
        setShiftManager(new ShiftManager());
        scheduleBean = getShiftManager().getBean();
    }

    @Override
    public void updateUi() {
        String cmd = super.getUserInput();

        if (super.parseCmd(cmd)) {
            this.updateUi();
            return;
        }

        switch (cmd) {
            case "1":
            case "assign_shift":
                assignShift();
                break;
            case "get_employee_schedule":
            case "2":
                getEmployeeSchedule();
                break;
            case "view_schedules":
            case "3":
                viewSchedules();
                break;
            case "help":
            case "4":
                help();
                updateUi();
                break;
            case "exit":
            case "5":
                viewSchedules();
                break;
            case "account":
            case "6":
                showAccountInfo();
                break;
            default:
                logger.warning("Something wrong");
                updateUi();
                break;
        }
    }


    private void getEmployeeSchedule() {
    }

    private void assignShift() {
    }

    private void viewSchedules() {
        this.shiftManager.pullSchedules();
        String schedules = this.scheduleBean.getAllShiftSchedules();
        outline(schedules);
        updateUi();
    }

    public ShiftManager getShiftManager() {
        return shiftManager;
    }

    public void setShiftManager(ShiftManager shiftManager) {
        this.shiftManager = shiftManager;
    }
}
