package com.roadbull.driver.models.response;

import com.roadbull.driver.models.HistoryItem;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class HistoryResponse {
    private int Code;
    private List<HistoryItem> Result;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public List<HistoryItem> getResult() {
        return Result;
    }

    public void setResult(List<HistoryItem> result) {
        Result = result;
    }
}
