package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class TrackLocation {
    private String ConsignmentNumber;
    private String JobId;
    private double Latitude;
    private double Longitude;


    public String getConsignmentNumber() {
        return ConsignmentNumber;
    }

    public void setConsignmentNumber(String consignmentNumber) {
        ConsignmentNumber = consignmentNumber;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
