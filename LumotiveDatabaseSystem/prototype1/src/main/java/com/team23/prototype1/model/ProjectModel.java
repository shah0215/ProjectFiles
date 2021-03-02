package com.team23.prototype1.model;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Himani
 *
 */
@Component
public class ProjectModel {

    private String projectId;
    private String projectName, projectDescription, startDate, endDate, associatedParts;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(String associatedParts) {
        this.associatedParts = associatedParts;
    }

}
