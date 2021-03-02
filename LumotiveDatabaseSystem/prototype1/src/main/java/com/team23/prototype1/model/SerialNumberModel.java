package com.team23.prototype1.model;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Himani
 *
 */
@Component
public class SerialNumberModel {

    private String id, partNumber, revId, serialNumber, dateReceived, supplierLotNumber, supplierSerialNumber, status,
            location, customer, testData, comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getRevId() {
        return revId;
    }

    public void setRevId(String revId) {
        this.revId = revId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getSupplierLotNumber() {
        return supplierLotNumber;
    }

    public void setSupplierLotNumber(String supplierLotNumber) {
        this.supplierLotNumber = supplierLotNumber;
    }

    public String getSupplierSerialNumber() {
        return supplierSerialNumber;
    }

    public void setSupplierSerialNumber(String supplierSerialNumber) {
        this.supplierSerialNumber = supplierSerialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
