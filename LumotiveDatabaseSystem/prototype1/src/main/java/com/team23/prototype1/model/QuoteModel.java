package com.team23.prototype1.model;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Himani
 *
 */
@Component
public class QuoteModel {

    private String partNumber, supplierName, quoteId, quoteLink, supplierLink, quoteDate, supplierPn, manufacturerPn,
            currency, qnpl;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    public void setQuoteLink(String quoteLink) {
        this.quoteLink = quoteLink;
    }

    public String getSupplierLink() {
        return supplierLink;
    }

    public void setSupplierLink(String supplierLink) {
        this.supplierLink = supplierLink;
    }

    public String getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(String quoteDate) {
        this.quoteDate = quoteDate;
    }

    public String getSupplierPn() {
        return supplierPn;
    }

    public void setSupplierPn(String supplierPn) {
        this.supplierPn = supplierPn;
    }

    public String getManufacturerPn() {
        return manufacturerPn;
    }

    public void setManufacturerPn(String manufacturerPn) {
        this.manufacturerPn = manufacturerPn;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getQnpl() {
        return qnpl;
    }

    public void setQnpl(String qnpl) {
        this.qnpl = qnpl;
    }

}
