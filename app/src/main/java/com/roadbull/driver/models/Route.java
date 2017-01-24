package com.roadbull.driver.models;

import android.location.Location;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class Route {
    private int Stops;
    private double NetProfit;
    private List<Integer> Steps;
    private List<Double> Distances;
    private List<Integer> Loads;
    private List<Double> Profits;
    private List<Double> DrivingTimes;
    private List<Double> Arrivals;
    private List<Double> Departures;
    private List<Double> WorkingTime;
    private String Path;
    private List<LocationItem> FootSteps;

    public int getStops() {
        return Stops;
    }

    public void setStops(int stops) {
        Stops = stops;
    }

    public double getNetProfit() {
        return NetProfit;
    }

    public void setNetProfit(double netProfit) {
        NetProfit = netProfit;
    }

    public List<Integer> getSteps() {
        return Steps;
    }

    public void setSteps(List<Integer> steps) {
        Steps = steps;
    }

    public List<Double> getDistances() {
        return Distances;
    }

    public void setDistances(List<Double> distances) {
        Distances = distances;
    }

    public List<Integer> getLoads() {
        return Loads;
    }

    public void setLoads(List<Integer> loads) {
        Loads = loads;
    }

    public List<Double> getProfits() {
        return Profits;
    }

    public void setProfits(List<Double> profits) {
        Profits = profits;
    }

    public List<Double> getDrivingTimes() {
        return DrivingTimes;
    }

    public void setDrivingTimes(List<Double> drivingTimes) {
        DrivingTimes = drivingTimes;
    }

    public List<Double> getArrivals() {
        return Arrivals;
    }

    public void setArrivals(List<Double> arrivals) {
        Arrivals = arrivals;
    }

    public List<Double> getDepartures() {
        return Departures;
    }

    public void setDepartures(List<Double> departures) {
        Departures = departures;
    }

    public List<Double> getWorkingTime() {
        return WorkingTime;
    }

    public void setWorkingTime(List<Double> workingTime) {
        WorkingTime = workingTime;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public List<LocationItem> getFootSteps() {
        return FootSteps;
    }

    public void setFootSteps(List<LocationItem> footSteps) {
        FootSteps = footSteps;
    }
}
