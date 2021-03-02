package com.team23.prototype1.dao;

import java.util.ArrayList;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.team23.prototype1.model.PartTypeModel;

/**
 * 
 * @author himani
 *
 */
public class PartTypeDao extends DatabaseConnectivity {

    /**
     * Arraylist to store PartTypeModel objects loaded with data from each row
     */
    public static ArrayList<PartTypeModel> data = new ArrayList<>();

    /**
     * Inserting data to database
     * 
     * @param obj=PartTypeModel
     * @throws IOException
     */
    public static void addData(PartTypeModel obj) throws IOException {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();
            addStmt.executeUpdate(
                    "INSERT INTO part_type (PART_TYPE_ID, DESCRIPTION, CUSTOM_FIELD1, CUSTOM_FIELD2, CUSTOM_FIELD3, CUSTOM_FIELD4, CUSTOM_FIELD5) VALUES ('"
                            + obj.getPartTypeId() + "', '" + obj.getPartTypeDescription() + "','"
                            + obj.getCustomField1() + "', '" + obj.getCustomField2() + "', '" + obj.getCustomField3()
                            + "','" + obj.getCustomField4() + "', '" + obj.getCustomField5() + "'); ");

            addStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * delete by id=pk
     * 
     * @param id=String
     */
    public static void deleteRowbyPartID(String id) {

        Statement deleteStmt = null;

        try {
            deleteStmt = conn.createStatement();
            deleteStmt.executeUpdate(
                    "UPDATE `prototype2`.`part_type` SET `IS_DELETED` = '1' WHERE (`PART_TYPE_ID` = '" + id + "');");

            deleteStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * edit by PK ID
     * 
     * @param id=PK
     * @param obj=PartTypeModel
     */
    public static void editRowByPartID(String id, PartTypeModel obj) {

        Statement updateStmt = null;

        try {
            updateStmt = conn.createStatement();
            updateStmt.executeUpdate("UPDATE part_type SET ID='" + obj.getPartTypeId() + "'," + "DESCRIPTION='"
                    + obj.getPartTypeDescription() + "'," + "CUSTOM_FIELD1='" + obj.getCustomField1() + "',"
                    + "CUSTOM_FIELD2='" + obj.getCustomField2() + "'," + "CUSTOM_FIELD3='" + obj.getCustomField3()
                    + "'," + "CUSTOM_FIELD4='" + obj.getCustomField4() + "'," + "CUSTOM_FIELD5='"
                    + obj.getCustomField5() + "'" + "  WHERE ID='" + id + "';");

            updateStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * Refreshes the ArrayList<PartTypeModel>
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part_type where IS_DELETED = false");
            data.clear();

            while (rs.next()) {

                PartTypeModel partData = new PartTypeModel();

                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));

                partData.setPartTypeDescription(rs.getString("DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD5"));
                setData(partData);
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
     * getter for PartTypeModel
     * 
     * @param index
     * @return
     */
    public static PartTypeModel getData(int index) {
        return data.get(index);
    }

    /**
     * Adds the new object to the data List
     * 
     * @param object=PartTypeModel
     */
    public static void setData(PartTypeModel object) {
        data.add(object);
    }

    /**
     * grabs and updates the ArrayList data with newest record on top
     * 
     */
    public static void sortByNewest() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part_type where IS_DELETED = false order by CREATED DESC;");
            data.clear();

            while (rs.next()) {

                PartTypeModel partData = new PartTypeModel();

                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));

                partData.setPartTypeDescription(rs.getString("DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD5"));
                setData(partData);
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
     * grabs and updates the ArrayList data with oldest record on top
     * 
     */
    public static void sortByOldest() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part_type where IS_DELETED = false order by CREATED ASC;");
            data.clear();

            while (rs.next()) {

                PartTypeModel partData = new PartTypeModel();

                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));

                partData.setPartTypeDescription(rs.getString("DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD5"));
                setData(partData);
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
     * grabs and updates the ArrayList data with PartTypeID descending record on top
     * 
     */
    public static void sortByDescID() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part_type where IS_DELETED = false order by PART_TYPE_ID DESC;");
            data.clear();

            while (rs.next()) {

                PartTypeModel partData = new PartTypeModel();

                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));

                partData.setPartTypeDescription(rs.getString("DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD5"));
                setData(partData);
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
     * grabs and updates the ArrayList data with PartTypeID ascending record on top
     * 
     */
    public static void sortByAscID() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part_type where IS_DELETED = false order by PART_TYPE_ID ASC;");
            data.clear();

            while (rs.next()) {

                PartTypeModel partData = new PartTypeModel();

                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));

                partData.setPartTypeDescription(rs.getString("DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD5"));
                setData(partData);
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

}
