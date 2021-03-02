package com.team23.prototype1.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is to store the data from Dataset of Quantity, NRE, PRice and Lead Time
 * from Quote Table, This class is to deserialize the Json Array of Quantity,
 * NRE, PRice and Lead Time dataset
 * 
 * @author Himani
 *
 */
public class QNPL implements Serializable {

    ArrayList<String> quantity, nre, price, leadTime;

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<String> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getNre() {
        return nre;
    }

    public void setNre(ArrayList<String> nre) {
        this.nre = nre;
    }

    public ArrayList<String> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<String> price) {
        this.price = price;
    }

    public ArrayList<String> getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(ArrayList<String> leadTime) {
        this.leadTime = leadTime;
    }

}
