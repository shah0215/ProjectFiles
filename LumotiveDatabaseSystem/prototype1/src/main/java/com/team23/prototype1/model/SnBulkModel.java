package com.team23.prototype1.model;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Himani
 *
 */
@Component
public class SnBulkModel {

    private String id, partNumber, revId, dateReceived, quantityReceived, supplier, supplierPn, supplierLotNumber,
            comments;

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

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(String quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierPn() {
        return supplierPn;
    }

    public void setSupplierPn(String supplierPn) {
        this.supplierPn = supplierPn;
    }

    public String getSupplierLotNumber() {
        return supplierLotNumber;
    }

    public void setSupplierLotNumber(String supplierLotNumber) {
        this.supplierLotNumber = supplierLotNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
