package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class RoadBullUser {
    private int Id;
    private String Email;
    private String Address;
    private String Country;
    private String Mobile;
    private String Name;
    private String Photo;
    private String DrivingLicense;
    private String ICNumber;
    private String StaffNumber;
    private boolean IsDriver;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getDrivingLicense() {
        return DrivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        DrivingLicense = drivingLicense;
    }

    public String getICNumber() {
        return ICNumber;
    }

    public void setICNumber(String ICNumber) {
        this.ICNumber = ICNumber;
    }

    public String getStaffNumber() {
        return StaffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        StaffNumber = staffNumber;
    }

    public boolean isDriver() {
        return IsDriver;
    }

    public void setDriver(boolean driver) {
        IsDriver = driver;
    }


}
