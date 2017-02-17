package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class Job {
    private int Id;
    private int VehicleId;
    private String VehicleNumber;
    private String TakenOn;
    private String TakenBy;
    private int TotalPickups;
    private String CreatedOn;
    private String TotalDistances;
    private String TotalDrivingTime;
    private String TotalWorkingTime;
    private int TotalDeliveries;
    private RBRoute Routes;

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

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
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

    public int getTotalDeliveries() {
        return TotalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        TotalDeliveries = totalDeliveries;
    }

    public RBRoute getRoutes() {
        return Routes;
    }

    public void setRoutes(RBRoute routes) {
        Routes = routes;
    }
}
