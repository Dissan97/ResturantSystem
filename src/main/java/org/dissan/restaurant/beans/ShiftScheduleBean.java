package org.dissan.restaurant.beans;

import org.dissan.restaurant.beans.api.ShiftScheduleBeanApi;
import org.dissan.restaurant.models.ShiftSchedule;

import java.util.List;

public class ShiftScheduleBean implements ShiftScheduleBeanApi {

    private ShiftSchedule shiftSchedule;
    private List<ShiftSchedule> shiftScheduleList;

    public ShiftScheduleBean(ShiftSchedule shiftSchedule) {
        this.setShiftSchedule(shiftSchedule);
    }

    public void setUpdateRequestList(List<ShiftSchedule> ssl) {
        this.shiftScheduleList = ssl;
    }

    public void setShiftSchedule(ShiftSchedule ss) {
        this.shiftSchedule = ss;
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public List<ShiftSchedule> getShiftScheduleList() {
        return shiftScheduleList;
    }

    @Override
    public String getAllShiftSchedules() {
        return this.shiftSchedule.toString();
    }

    @Override
    public String getShiftInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shift schedules").append('\n');
        for (ShiftSchedule ss:
             this.shiftScheduleList) {
            builder.append(ss.toString()).append('\n');
        }
        return builder.toString();
    }

    public void setShiftScheduleList(List<ShiftSchedule> schedules) {
        this.shiftScheduleList = schedules;
    }
}
