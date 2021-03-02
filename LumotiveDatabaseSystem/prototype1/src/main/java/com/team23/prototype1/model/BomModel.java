package com.team23.prototype1.model;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Himani
 *
 */
@Component
public class BomModel {

    /** The parent part number. */
    private String parentPartNumber;

    /** The child part number. */
    private String childPartTextLink;

    public String getParentPartNumber() {
        return parentPartNumber;
    }

    public void setParentPartNumber(String parentPartNumber) {
        this.parentPartNumber = parentPartNumber;
    }

    public String getChildPartTextLink() {
        return childPartTextLink;
    }

    public void setChildPartTextLink(String childPartTextLink) {
        this.childPartTextLink = childPartTextLink;
    }

}
