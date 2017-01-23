package com.roadbull.driver.models.response;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class LoginResponse {
    private int Code;
    private String Message;
    private String Token;
    private String ExpiredOn;
    private List<String> Roles;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getExpiredOn() {
        return ExpiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        ExpiredOn = expiredOn;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }
}
