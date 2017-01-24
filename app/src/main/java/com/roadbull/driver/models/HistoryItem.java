package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class HistoryItem {
    private int Id;
    private int VehicleId;
    private String VehicleNumber;
    private String TakenOn;
    private String TakenBy;
    private int TotalPickups;
    private int TotalDeliveries;
    private String TotalDistances;
    private String TotalDrivingTime;
    private String TotalWorkingTime;
    private String CompletedOn;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getTakenOn() {
        return TakenOn;
    }

    public void setTakenOn(String takenOn) {
        TakenOn = takenOn;
    }

    public String getTakenBy() {
        return TakenBy;
    }

    public void setTakenBy(String takenBy) {
        TakenBy = takenBy;
    }

    public int getTotalPickups() {
        return TotalPickups;
    }

    public void setTotalPickups(int totalPickups) {
        TotalPickups = totalPickups;
    }

    public int getTotalDeliveries() {
        return TotalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        TotalDeliveries = totalDeliveries;
    }

    public String getTotalDistances() {
        return TotalDistances;
    }

    public void setTotalDistances(String totalDistances) {
        TotalDistances = totalDistances;
    }

    public String getTotalDrivingTime() {
        return TotalDrivingTime;
    }

    public void setTotalDrivingTime(String totalDrivingTime) {
        TotalDrivingTime = totalDrivingTime;
    }

    public String getTotalWorkingTime() {
        return TotalWorkingTime;
    }

    public void setTotalWorkingTime(String totalWorkingTime) {
        TotalWorkingTime = totalWorkingTime;
    }

    public String getCompletedOn() {
        return CompletedOn;
    }

    public void setCompletedOn(String completedOn) {
        CompletedOn = completedOn;
    }
}
