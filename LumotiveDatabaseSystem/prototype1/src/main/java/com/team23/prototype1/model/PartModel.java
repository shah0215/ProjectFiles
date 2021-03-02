package com.team23.prototype1.model;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Himani
 *
 */
@Component
public class PartModel {

    /** The part id. */
    private int partId;

    /** The part type id. */
    private int partTypeId;

    /** The rev id. */
    private int revId;

    /** The part description. */
    private String partDescription;

    /** The part code. */
    private String partCode;

    /** The releases. */
    private boolean releases;

    /** The part folder link. */
    private String partFolderLink;

    /** The inspection document. */
    private String inspectionDocument;

    /** The assembly test plan. */
    private String assemblyTestPlan;

    /** The track inventory. */
    private boolean trackInventory;

    /** The track cost. */
    private boolean trackCost;

    /** The track test data. */
    private boolean trackTestData;

    /** The custome field 5. */
    private String customField1, customField2, customField3, customField4, customField5;

    /**
     * Gets the part id.
     *
     * @return the part id
     */
    public int getPartId() {
        return partId;
    }

    /**
     * Sets the part id.
     *
     * @param partId the new part id
     */
    public void setPartId(int partId) {
        this.partId = partId;
    }

    /**
     * Gets the part type id.
     *
     * @return the part type id
     */
    public int getPartTypeId() {
        return partTypeId;
    }

    /**
     * Sets the part type id.
     *
     * @param partTypeId the new part type id
     */
    public void setPartTypeId(int partTypeId) {
        this.partTypeId = partTypeId;
    }

    /**
     * Gets the rev id.
     *
     * @return the rev id
     */
    public int getRevId() {
        return revId;
    }

    /**
     * Sets the rev id.
     *
     * @param revId the new rev id
     */
    public void setRevId(int revId) {
        this.revId = revId;
    }

    /**
     * Gets the part description.
     *
     * @return the part description
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * Sets the part description.
     *
     * @param partDescription the new part description
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    /**
     * Gets the part code.
     *
     * @return the part code
     */
    public String getPartCode() {
        return partCode;
    }

    /**
     * Sets the part code.
     *
     * @param partCode the new part code
     */
    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    /**
     * Checks if is releases.
     *
     * @return true, if is releases
     */
    public boolean isReleases() {
        return releases;
    }

    /**
     * Sets the releases.
     *
     * @param releases the new releases
     */
    public void setReleases(boolean releases) {
        this.releases = releases;
    }

    /**
     * Gets the part folder link.
     *
     * @return the part folder link
     */
    public String getPartFolderLink() {
        return partFolderLink;
    }

    /**
     * Sets the part folder link.
     *
     * @param partFolderLink the new part folder link
     */
    public void setPartFolderLink(String partFolderLink) {
        this.partFolderLink = partFolderLink;
    }

    /**
     * Gets the inspection document.
     *
     * @return the inspection document
     */
    public String getInspectionDocument() {
        return inspectionDocument;
    }

    /**
     * Sets the inspection document.
     *
     * @param inspectionDocument the new inspection document
     */
    public void setInspectionDocument(String inspectionDocument) {
        this.inspectionDocument = inspectionDocument;
    }

    /**
     * Gets the assembly test plan.
     *
     * @return the assembly test plan
     */
    public String getAssemblyTestPlan() {
        return assemblyTestPlan;
    }

    /**
     * Sets the assembly test plan.
     *
     * @param assemblyTestPlan the new assembly test plan
     */
    public void setAssemblyTestPlan(String assemblyTestPlan) {
        this.assemblyTestPlan = assemblyTestPlan;
    }

    /**
     * Checks if is track inventory.
     *
     * @return true, if is track inventory
     */
    public boolean isTrackInventory() {
        return trackInventory;
    }

    /**
     * Sets the track inventory.
     *
     * @param trackInventory the new track inventory
     */
    public void setTrackInventory(boolean trackInventory) {
        this.trackInventory = trackInventory;
    }

    /**
     * Checks if is track cost.
     *
     * @return true, if is track cost
     */
    public boolean isTrackCost() {
        return trackCost;
    }

    /**
     * Sets the track cost.
     *
     * @param trackCost the new track cost
     */
    public void setTrackCost(boolean trackCost) {
        this.trackCost = trackCost;
    }

    /**
     * Checks if is track test data.
     *
     * @return true, if is track test data
     */
    public boolean isTrackTestData() {
        return trackTestData;
    }

    /**
     * Sets the track test data.
     *
     * @param trackTestData the new track test data
     */
    public void setTrackTestData(boolean trackTestData) {
        this.trackTestData = trackTestData;
    }

    /**
     * Gets the custom field 1.
     *
     * @return the custom field 1
     */
    public String getCustomField1() {
        return customField1;
    }

    /**
     * Sets the custom field 1.
     *
     * @param customField1 the new custom field 1
     */
    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    /**
     * Gets the custom field 2.
     *
     * @return the custom field 2
     */
    public String getCustomField2() {
        return customField2;
    }

    /**
     * Sets the custom field 2.
     *
     * @param customField2 the new custom field 2
     */
    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    /**
     * Gets the custom field 3.
     *
     * @return the custom field 3
     */
    public String getCustomField3() {
        return customField3;
    }

    /**
     * Sets the custom field 3.
     *
     * @param customField3 the new custom field 3
     */
    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    /**
     * Gets the custom field 4.
     *
     * @return the custom field 4
     */
    public String getCustomField4() {
        return customField4;
    }

    /**
     * Sets the custom field 4.
     *
     * @param customField4 the new custom field 4
     */
    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    /**
     * Gets the custom field 5.
     *
     * @return the custom field 5
     */
    public String getCustomField5() {
        return customField5;
    }

    /**
     * Sets the custom field 5.
     *
     * @param customField5 the new custom field 5
     */
    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

}
