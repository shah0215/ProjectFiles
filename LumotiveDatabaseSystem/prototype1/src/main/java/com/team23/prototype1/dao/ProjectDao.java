package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team23.prototype1.model.ProjectModel;

/**
 * 
 * @author Himani
 *
 */
public class ProjectDao extends DatabaseConnectivity {
    /**
     * ArrayList of ProjectModel object carries data from database rows as objects
     */
    public static ArrayList<ProjectModel> projectData = new ArrayList<>();

    /**
     * Inserting data Database by passing ProjectModel object
     * 
     * @param obj=ProjectModel
     */
    public static void addData(ProjectModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`project` (`PROJECT_NAME`, `PROJECT_DESCRIPTION`, `START_DATE`, `END_DATE`, `ASSOCIATED_PARTS`) VALUES ('"
                            + obj.getProjectName() + "', '" + obj.getProjectDescription() + "', '" + obj.getStartDate()
                            + "', '" + obj.getEndDate() + "', '" + obj.getAssociatedParts() + "');\r\n" + "");

            addStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * 
     * @return ArrayList of sorted data by newest record on top
     */
    public static ArrayList<ProjectModel> sortByNewest() {

        ArrayList<ProjectModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Project where IS_DELETED = false order by CREATED DESC;");

            while (rs.next()) {

                ProjectModel projectData = new ProjectModel();
                projectData.setProjectId(String.format("%04d", Integer.valueOf(rs.getString("PROJECT_ID"))));
                projectData.setProjectName(rs.getString("PROJECT_NAME"));
                projectData.setProjectDescription(rs.getString("PROJECT_DESCRIPTION"));
                projectData.setStartDate(rs.getString("START_DATE"));
                projectData.setEndDate(rs.getString("END_DATE"));
                projectData.setAssociatedParts(rs.getString("ASSOCIATED_PARTS"));
                sorted.add(projectData);

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return sorted;
    }

    /**
     * 
     * @return ArrayList of sorted data by oldest record on top
     */
    public static ArrayList<ProjectModel> sortByOldest() {

        ArrayList<ProjectModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM PROJECT where IS_DELETED = false order by CREATED ASC;");

            while (rs.next()) {

                ProjectModel projectData = new ProjectModel();
                projectData.setProjectId(String.format("%04d", Integer.valueOf(rs.getString("PROJECT_ID"))));
                projectData.setProjectName(rs.getString("PROJECT_NAME"));
                projectData.setProjectDescription(rs.getString("PROJECT_DESCRIPTION"));
                projectData.setStartDate(rs.getString("START_DATE"));
                projectData.setEndDate(rs.getString("END_DATE"));
                projectData.setAssociatedParts(rs.getString("ASSOCIATED_PARTS"));
                sorted.add(projectData);
            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return sorted;
    }

    /**
     * Refreshes the ProjectData as the data gets updated
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM project where IS_DELETED = false");
            projectData.clear();

            while (rs.next()) {

                ProjectModel projectData = new ProjectModel();
                projectData.setProjectId(String.format("%04d", Integer.valueOf(rs.getString("PROJECT_ID"))));
                projectData.setProjectName(rs.getString("PROJECT_NAME"));
                projectData.setProjectDescription(rs.getString("PROJECT_DESCRIPTION"));
                projectData.setStartDate(rs.getString("START_DATE"));
                projectData.setEndDate(rs.getString("END_DATE"));
                projectData.setAssociatedParts(rs.getString("ASSOCIATED_PARTS"));

                setData(projectData);
            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * 
     * @return list of Part Type Ids
     */
    public static ArrayList<Integer> partTypeIds() {

        ArrayList<Integer> partTypeIds = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PART_TYPE_ID FROM PROTOTYPE2.part where IS_DELETED = false");

            while (rs.next()) {

                partTypeIds.add((rs.getInt("PART_TYPE_ID")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return partTypeIds;

    }

    /**
     * 
     * @return list of Part IDs
     */
    public static ArrayList<Integer> partIds() {

        ArrayList<Integer> partIds = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT part_id FROM part where IS_DELETED = false");

            while (rs.next()) {

                partIds.add(rs.getInt("PART_ID"));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return partIds;

    }

    /**
     * Deleting by Row by PK
     * 
     * @param projectID=PK
     */
    public static void deleteByProjectId(String projectID) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "UPDATE `prototype2`.`project` SET `IS_DELETED` = '1' WHERE (`PROJECT_ID` = '" + projectID + "');");

            stmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * editing by ProjectID
     * 
     * @param projectID
     * @param obj
     */
    public static void editByProjectId(String projectID, ProjectModel obj) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`project` SET `PROJECT_NAME` = '" + obj.getProjectName()
                    + "', `PROJECT_DESCRIPTION` = '" + obj.getProjectDescription() + "', `START_DATE` = '"
                    + obj.getStartDate() + "', `END_DATE` = '" + obj.getEndDate() + "', `ASSOCIATED_PARTS` = '"
                    + obj.getAssociatedParts() + "' WHERE (`PROJECT_ID` = '" + projectID + "');");

            stmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * getters and setters for the projectData Arraylist
     * 
     * @param index
     * @return
     */
    public static ProjectModel getData(int index) {
        return projectData.get(index);
    }

    public static void setData(ProjectModel projectData2) {
        projectData.add(projectData2);
    }

}
