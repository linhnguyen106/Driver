package com.roadbull.driver.manager;

import android.content.SharedPreferences;
import android.provider.ContactsContract;

/**
 * Created by linhnguyenv1 on 2/8/2017.
 */

public class PrefManager {
    private final static String USER_PASSWORD_KEY = "password_key";
    private final static String REMEMBER_ACCOUNT = "remember_account";
    private final static String TOKEN_KEY = "token_key";
    private final static String USER_NAME_KEY = "username_key";
    private final static String USER_ID_KEY ="user_id_key";
    private final static String USER_EMAIL_KEY = "user_email_key";
    private final static String USER_ADDRESS_KEY = "user_add_key";
    private final static String USER_COUNTRY_KEY = "user_country_key";
    private final static String USER_MOBILE_KEY = "user_mobile_key";
    private final static String USER_FULLNAME_KEY = "user_fullname_key";
    private final static String USER_PHOTO_KEY ="user_photo_key";
    private final static String USER_DRIVING_LICENSE_KEY = "driver_license_key";
    private final static String USER_IC_NUMBER_KEY = "user_ic_number_key";
    private final static String USER_STAFF_NUMBER_KEY = "user_staff_number_key";
    private final static String USER_VEHICLE_NUMBER_KEY = "user_vehicle_number_key";
    private final static String USER_VEHICLE_TYPE_KEY = "user_vehicle_type_key";


    private String password;
    private boolean isRemember;
    private String token;
    private String userName;
    private String userId;
    private String email;
    private String address;
    private String country;
    private String mobile;
    private String fullName;
    private String photo;
    private String drivingLicense;
    private String icNumber;
    private String staffNum;
    private String vehicleNum;
    private String vehicleType;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public PrefManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public static PrefManager getInstance(SharedPreferences sharedPreferences){
        PrefManager instance = new PrefManager(sharedPreferences);
        return  instance;
    }


    public String getPassword() {
        return sharedPreferences.getString(USER_PASSWORD_KEY,"");
    }

    public void setPassword(String password) {
        editor.putString(USER_PASSWORD_KEY,password);
        editor.commit();
    }

    public boolean isRemember() {
        return sharedPreferences.getBoolean(REMEMBER_ACCOUNT,false);
    }

    public void setRemember(boolean remember) {
       editor.putBoolean(REMEMBER_ACCOUNT,remember);
        editor.commit();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN_KEY,"");
    }

    public void setToken(String token) {
        editor.putString(TOKEN_KEY,token);
        editor.commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(USER_NAME_KEY,"");
    }

    public void setUserName(String userName) {
        editor.putString(USER_NAME_KEY,userName).commit();
    }

    public String getUserId() {
        return sharedPreferences.getString(USER_ID_KEY,"");
    }

    public void setUserId(String userId) {
       editor.putString(USER_ID_KEY,userId).commit();
    }

    public String getEmail() {
        return sharedPreferences.getString(USER_EMAIL_KEY,"");
    }

    public void setEmail(String email) {
       editor.putString(USER_EMAIL_KEY,email).commit();
    }

    public String getAddress() {
        return sharedPreferences.getString(USER_ADDRESS_KEY,"");
    }

    public void setAddress(String address) {
        editor.putString(USER_ADDRESS_KEY,address).commit();
    }

    public String getCountry() {
        return sharedPreferences.getString(USER_COUNTRY_KEY,"");
    }

    public void setCountry(String country) {
        editor.putString(USER_COUNTRY_KEY,country).commit();
    }

    public String getMobile() {
        return sharedPreferences.getString(USER_MOBILE_KEY,"");
    }

    public void setMobile(String mobile) {
        editor.putString(USER_MOBILE_KEY,mobile).commit();
    }

    public String getFullName() {
        return sharedPreferences.getString(USER_FULLNAME_KEY,"");
    }

    public void setFullName(String fullName) {
        editor.putString(USER_FULLNAME_KEY,fullName).commit();
    }

    public String getPhoto() {
        return sharedPreferences.getString(USER_PHOTO_KEY,"");
    }

    public void setPhoto(String photo) {
        editor.putString(USER_PHOTO_KEY,photo).commit();
    }

    public String getDrivingLicense() {
        return sharedPreferences.getString(USER_DRIVING_LICENSE_KEY,"");
    }

    public void setDrivingLicense(String drivingLicense) {
        editor.putString(USER_DRIVING_LICENSE_KEY,drivingLicense).commit();
    }

    public String getIcNumber() {
        return sharedPreferences.getString(USER_IC_NUMBER_KEY,"");
    }

    public void setIcNumber(String icNumber) {
        editor.putString(USER_IC_NUMBER_KEY,icNumber).commit();
    }

    public String getStaffNum() {
        return sharedPreferences.getString(USER_STAFF_NUMBER_KEY,"");
    }

    public void setStaffNum(String staffNum) {
        editor.putString(USER_STAFF_NUMBER_KEY,staffNum).commit();
    }

    public String getVehicleNum() {
        return sharedPreferences.getString(USER_VEHICLE_NUMBER_KEY,"");
    }

    public void setVehicleNum(String vehicleNum) {
        editor.putString(USER_VEHICLE_NUMBER_KEY,vehicleNum).commit();
    }

    public String getVehicleType() {
        return sharedPreferences.getString(USER_VEHICLE_TYPE_KEY,"");
    }

    public void setVehicleType(String vehicleType) {
        editor.putString(USER_VEHICLE_TYPE_KEY,vehicleType).commit();
    }
}
