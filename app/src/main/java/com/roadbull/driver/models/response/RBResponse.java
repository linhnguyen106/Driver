package com.roadbull.driver.models.response;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class RBResponse {
    private int Code;
    private String Message;

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
}
