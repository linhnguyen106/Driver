package com.roadbull.driver.models;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linhnguyenv1 on 2/10/2017.
 */

public class JobDetail {
    private int JobId;
    private String FromName;
    private String FromCompany;
    private String FromAddress;
    private String FromMobilePhone;
    private String ToName;
    private String ToAddress;
    private String ToCompany;
    private String ToMobilePhone;
    private List<String> ConsignmentNumber;
    private List<Order> Orders;
    private Integer Type;
    private String SizeName;
    private boolean IsDone;
    private LocationItem FromGeolocation;
    private LocationItem ToGeolocation;

    private String OperatorRemark ;
   // private String ExtraRequests;
    private Integer PickupTimeSlotId;
    private Integer DeliveryTimeSlotId;
    private List<TimeSlot> Timeslots;
    private boolean HasRemark;
    private String PostalCode;
    private boolean HasFailed;

    private String TimeSlotString;

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public String getFromName() {
        return FromName;
    }

    public void setFromName(String fromName) {
        FromName = fromName;
    }

    public String getFromCompany() {
        return FromCompany;
    }

    public void setFromCompany(String fromCompany) {
        FromCompany = fromCompany;
    }

    public String getFromAddress() {
        return FromAddress;
    }

    public void setFromAddress(String fromAddress) {
        FromAddress = fromAddress;
    }

    public String getFromMobilePhone() {
        return FromMobilePhone;
    }

    public void setFromMobilePhone(String fromMobilePhone) {
        FromMobilePhone = fromMobilePhone;
    }

    public String getToName() {
        return ToName;
    }

    public void setToName(String toName) {
        ToName = toName;
    }

    public String getToAddress() {
        return ToAddress;
    }

    public void setToAddress(String toAddress) {
        ToAddress = toAddress;
    }

    public String getToCompany() {
        return ToCompany;
    }

    public void setToCompany(String toCompany) {
        ToCompany = toCompany;
    }

    public String getToMobilePhone() {
        return ToMobilePhone;
    }

    public void setToMobilePhone(String toMobilePhone) {
        ToMobilePhone = toMobilePhone;
    }

    public List<String> getConsignmentNumber() {
        return ConsignmentNumber;
    }

    public void setConsignmentNumber(List<String> consignmentNumber) {
        ConsignmentNumber = consignmentNumber;
    }

    public List<Order> getOrders() {
        return Orders == null ? new ArrayList<Order>() : Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }

    public Integer getType() {
        return Type == null ? 0 : Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String sizeName) {
        SizeName = sizeName;
    }

    public boolean isDone() {
        return IsDone;
    }

    public void setDone(boolean done) {
        IsDone = done;
    }

    public LocationItem getFromGeolocation() {
        return FromGeolocation;
    }

    public void setFromGeolocation(LocationItem fromGeolocation) {
        FromGeolocation = fromGeolocation;
    }

    public LocationItem getToGeolocation() {
        return ToGeolocation;
    }

    public void setToGeolocation(LocationItem toGeolocation) {
        ToGeolocation = toGeolocation;
    }

    public String getOperatorRemark() {
        return OperatorRemark;
    }

    public void setOperatorRemark(String operatorRemark) {
        OperatorRemark = operatorRemark;
    }

    public Integer getPickupTimeSlotId() {
        return PickupTimeSlotId == null ? 0 : PickupTimeSlotId;
    }

    public void setPickupTimeSlotId(Integer pickupTimeSlotId) {
        PickupTimeSlotId = pickupTimeSlotId;
    }

    public Integer getDeliveryTimeSlotId() {
        return DeliveryTimeSlotId == null ? 0 : DeliveryTimeSlotId;
    }

    public void setDeliveryTimeSlotId(Integer deliveryTimeSlotId) {
        DeliveryTimeSlotId = deliveryTimeSlotId;
    }

    public List<TimeSlot> getTimeslots() {
        return Timeslots;
    }

    public void setTimeslots(List<TimeSlot> timeslots) {
        Timeslots = timeslots;
    }

    public boolean isHasRemark() {
        return HasRemark;
    }

    public void setHasRemark(boolean hasRemark) {
        HasRemark = hasRemark;
    }

    public String getPostalCode() {
        return TextUtils.isEmpty(PostalCode) ? "" : PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public boolean isHasFailed() {
        return HasFailed;
    }

    public void setHasFailed(boolean hasFailed) {
        HasFailed = hasFailed;
    }

    public String getTimeSlotString() {
        return TimeSlotString;
    }

    public void setTimeSlotString(String timeSlotString) {
        TimeSlotString = timeSlotString;
    }
}
