package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class Order {
    private int Id;
    private String CustomerId;
    private String BinCode;
    private String ConsignmentNumber;
    private String GroupTrackingNumber;
    private String OrderNumber;
    private String FromName;
    private String FromZipCode;
    private String FromAddress;
    private String FromMobilePhone;
    private String FromSignature;
    private String ToName;
    private String ToZipCode;
    private String ToAddress;
    private String ToMobilePhone;
    private String ToSignature;
    private int PaymentTypeId;
    private String Price;
    private int ServiceId;
    private int ProductTypeId;
    private int SizeId;
    private String Remark;
    private int Status;
    private int PickupTimeSlotId;
    private String PickupDate;
    private int DeliveryTimeSlotId;
    private RBSize Size;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getBinCode() {
        return BinCode;
    }

    public void setBinCode(String binCode) {
        BinCode = binCode;
    }

    public String getConsignmentNumber() {
        return ConsignmentNumber;
    }

    public void setConsignmentNumber(String consignmentNumber) {
        ConsignmentNumber = consignmentNumber;
    }

    public String getGroupTrackingNumber() {
        return GroupTrackingNumber;
    }

    public void setGroupTrackingNumber(String groupTrackingNumber) {
        GroupTrackingNumber = groupTrackingNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getFromName() {
        return FromName;
    }

    public void setFromName(String fromName) {
        FromName = fromName;
    }

    public String getFromZipCode() {
        return FromZipCode;
    }

    public void setFromZipCode(String fromZipCode) {
        FromZipCode = fromZipCode;
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

    public String getFromSignature() {
        return FromSignature;
    }

    public void setFromSignature(String fromSignature) {
        FromSignature = fromSignature;
    }

    public String getToName() {
        return ToName;
    }

    public void setToName(String toName) {
        ToName = toName;
    }

    public String getToZipCode() {
        return ToZipCode;
    }

    public void setToZipCode(String toZipCode) {
        ToZipCode = toZipCode;
    }

    public String getToAddress() {
        return ToAddress;
    }

    public void setToAddress(String toAddress) {
        ToAddress = toAddress;
    }

    public String getToMobilePhone() {
        return ToMobilePhone;
    }

    public void setToMobilePhone(String toMobilePhone) {
        ToMobilePhone = toMobilePhone;
    }

    public String getToSignature() {
        return ToSignature;
    }

    public void setToSignature(String toSignature) {
        ToSignature = toSignature;
    }

    public int getPaymentTypeId() {
        return PaymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        PaymentTypeId = paymentTypeId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int serviceId) {
        ServiceId = serviceId;
    }

    public int getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        ProductTypeId = productTypeId;
    }

    public int getSizeId() {
        return SizeId;
    }

    public void setSizeId(int sizeId) {
        SizeId = sizeId;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getPickupTimeSlotId() {
        return PickupTimeSlotId;
    }

    public void setPickupTimeSlotId(int pickupTimeSlotId) {
        PickupTimeSlotId = pickupTimeSlotId;
    }

    public String getPickupDate() {
        return PickupDate;
    }

    public void setPickupDate(String pickupDate) {
        PickupDate = pickupDate;
    }

    public int getDeliveryTimeSlotId() {
        return DeliveryTimeSlotId;
    }

    public void setDeliveryTimeSlotId(int deliveryTimeSlotId) {
        DeliveryTimeSlotId = deliveryTimeSlotId;
    }

    public RBSize getSize() {
        return Size;
    }

    public void setSize(RBSize size) {
        Size = size;
    }
}
