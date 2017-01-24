package com.roadbull.driver.models;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class RBLocation {
    private String OrderId;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerMobilePhone;
    private String CustomerCompany;
    private List<String> ConsignmentNumbers;
    private int Type;
    private boolean IsDone;
    private String SizeName;
    private String PostalCode;
    private List<Order> Orders;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerMobilePhone() {
        return CustomerMobilePhone;
    }

    public void setCustomerMobilePhone(String customerMobilePhone) {
        CustomerMobilePhone = customerMobilePhone;
    }

    public String getCustomerCompany() {
        return CustomerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        CustomerCompany = customerCompany;
    }

    public List<String> getConsignmentNumbers() {
        return ConsignmentNumbers;
    }

    public void setConsignmentNumbers(List<String> consignmentNumbers) {
        ConsignmentNumbers = consignmentNumbers;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public boolean isDone() {
        return IsDone;
    }

    public void setDone(boolean done) {
        IsDone = done;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String sizeName) {
        SizeName = sizeName;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }
}
