package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class TimeSlot {
    private int Id;
    private String Text;
    private String FromTime;
    private String ToTime;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getFromTime() {
        return FromTime;
    }

    public void setFromTime(String fromTime) {
        FromTime = fromTime;
    }

    public String getToTime() {
        return ToTime;
    }

    public void setToTime(String toTime) {
        ToTime = toTime;
    }
}
