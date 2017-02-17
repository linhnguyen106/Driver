package com.roadbull.driver.models.response;

import com.roadbull.driver.models.Job;
import com.roadbull.driver.models.TimeSlot;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class JobResponse {
    private int Code;
    private List<Job> Result;
    private List<TimeSlot> Timeslots;
    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public List<Job> getResult() {
        return Result;
    }

    public void setResult(List<Job> result) {
        Result = result;
    }

    public List<TimeSlot> getTimeslots() {
        return Timeslots;
    }

    public void setTimeslots(List<TimeSlot> timeslots) {
        Timeslots = timeslots;
    }
}
