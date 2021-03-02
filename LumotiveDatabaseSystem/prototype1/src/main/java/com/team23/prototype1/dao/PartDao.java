package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team23.prototype1.model.PartModel;

/**
 * 
 * @author himani
 *
 */
public class PartDao extends DatabaseConnectivity {
    /**
     * ArrayList= PartData to store each row as PartModel object
     */
    public static ArrayList<PartModel> PartData = new ArrayList<>();

    /**
     * inserting data
     * 
     * @param obj = PartModel
     */
    public static void addData(PartModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate("INSERT INTO part (PART_TYPE_ID, " + " REV_ID, PART_DESCRIPTION,"
                    + " PART_CODE,  PART_FOLDER_LINK, INSPECTION_DOCUMENT," + " ASSEMBLY_TEST_PLAN,  "
                    + " CUSTOM_FIELD_1, CUSTOM_FIELD_2, CUSTOM_FIELD_3," + " CUSTOM_FIELD_4, CUSTOM_FIELD_5) VALUES"
                    + " ('" + obj.getPartTypeId() + "', " + "'" + obj.getRevId() + "', '" + obj.getPartDescription()
                    + "'," + "'" + obj.getPartCode() + "'," + "'" + obj.getPartFolderLink() + "', '"
                    + obj.getInspectionDocument() + "'," + "'" + obj.getAssemblyTestPlan() + "', "

                    + "'" + obj.getCustomField1() + "', '" + obj.getCustomField2() + "'," + " '" + obj.getCustomField3()
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
     * deleting Data
     * 
     * @param id =PK
     */
    public static void deleteRowbyPartID(String id) {

        Statement deleteStmt = null;

        try {
            deleteStmt = conn.createStatement();
            deleteStmt.executeUpdate(
                    "UPDATE `prototype2`.`part` SET `IS_DELETED` = '1' WHERE (`PART_ID` = '" + id + "');");

            deleteStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * updating a row by id
     * 
     * @param id=pk
     * @param obj=PartModel
     */
    public static void editRowByPartID(String id, PartModel obj) {

        Statement updateStmt = null;

        try {
            updateStmt = conn.createStatement();
            updateStmt.executeUpdate("UPDATE `prototype2`.`part` SET `PART_TYPE_ID` = '" + obj.getPartTypeId()
                    + "', `REV_ID` = '" + obj.getRevId() + "', `PART_DESCRIPTION` = '" + obj.getPartDescription()
                    + "', `PART_CODE` = '" + obj.getPartCode() + "', `PART_FOLDER_LINK` = '" + obj.getPartFolderLink()
                    + "', `INSPECTION_DOCUMENT` = '" + obj.getInspectionDocument() + "', `ASSEMBLY_TEST_PLAN` = '"
                    + obj.getAssemblyTestPlan() + "', `CUSTOM_FIELD_1` = '" + obj.getCustomField1()
                    + "', `CUSTOM_FIELD_2` = '" + obj.getCustomField2() + "', `CUSTOM_FIELD_3` = '"
                    + obj.getCustomField3() + "', `CUSTOM_FIELD_4` = '" + obj.getCustomField4()
                    + "', `CUSTOM_FIELD_5` = '" + obj.getCustomField5() + "' WHERE (`PART_ID` = '" + id + "');\r\n"
                    + "");

            updateStmt.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * refreshing the PartData ArrayList
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part where IS_DELETED = false");
            PartData.clear();

            while (rs.next()) {

                PartModel partData = new PartModel();

                partData.setAssemblyTestPlan(rs.getString("ASSEMBLY_TEST_PLAN"));
                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));
                partData.setPartCode(rs.getString("PART_CODE"));
                partData.setReleases(rs.getBoolean("RELEASES"));
                partData.setTrackCost(rs.getBoolean("TRACK_COST"));
                partData.setRevId(rs.getInt("REV_ID"));
                partData.setPartId(rs.getInt("PART_ID"));
                partData.setInspectionDocument(rs.getString("INSPECTION_DOCUMENT"));
                partData.setTrackInventory(rs.getBoolean("TRACK_INVENTORY"));
                partData.setTrackTestData(rs.getBoolean("TRACK_TEST_DATA"));
                partData.setPartFolderLink(rs.getString("PART_FOLDER_LINK"));
                partData.setPartDescription(rs.getString("PART_DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD_1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD_2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD_3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD_4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD_5"));
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
     * 
     * @return Arraylist of PartIds
     */
    public static ArrayList<Integer> partIds() {

        ArrayList<Integer> partIds = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT part_type_id FROM part_type where IS_DELETED = false");

            while (rs.next()) {

                partIds.add(rs.getInt("PART_TYPE_ID"));

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
     * 
     * @param index= index of PartData list
     * @return
     */
    public static PartModel getData(int index) {
        return PartData.get(index);
    }

    /**
     * 
     * @param partData2 sets the data to ArrayList PartData
     */
    public static void setData(PartModel partData2) {
        PartData.add(partData2);
    }

    /**
     * grabs and stores the sorted data by newest record on top to objectss
     */
    public static void sortByNewest() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part where IS_DELETED = false order by CREATED DESC;");
            PartData.clear();

            while (rs.next()) {
                PartModel partData = new PartModel();

                partData.setAssemblyTestPlan(rs.getString("ASSEMBLY_TEST_PLAN"));
                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));
                partData.setPartCode(rs.getString("PART_CODE"));
                partData.setReleases(rs.getBoolean("RELEASES"));
                partData.setTrackCost(rs.getBoolean("TRACK_COST"));
                partData.setRevId(rs.getInt("REV_ID"));
                partData.setPartId(rs.getInt("PART_ID"));
                partData.setInspectionDocument(rs.getString("INSPECTION_DOCUMENT"));
                partData.setTrackInventory(rs.getBoolean("TRACK_INVENTORY"));
                partData.setTrackTestData(rs.getBoolean("TRACK_TEST_DATA"));
                partData.setPartFolderLink(rs.getString("PART_FOLDER_LINK"));
                partData.setPartDescription(rs.getString("PART_DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD_1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD_2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD_3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD_4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD_5"));
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
     * grabs and stores the sorted data by oldest record on top to objectss
     */
    public static void sortByOldest() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM part where IS_DELETED = false order by CREATED ASC;");
            PartData.clear();

            while (rs.next()) {

                PartModel partData = new PartModel();

                partData.setAssemblyTestPlan(rs.getString("ASSEMBLY_TEST_PLAN"));
                partData.setPartTypeId(rs.getInt("PART_TYPE_ID"));
                partData.setPartCode(rs.getString("PART_CODE"));
                partData.setReleases(rs.getBoolean("RELEASES"));
                partData.setTrackCost(rs.getBoolean("TRACK_COST"));
                partData.setRevId(rs.getInt("REV_ID"));
                partData.setPartId(rs.getInt("PART_ID"));
                partData.setInspectionDocument(rs.getString("INSPECTION_DOCUMENT"));
                partData.setTrackInventory(rs.getBoolean("TRACK_INVENTORY"));
                partData.setTrackTestData(rs.getBoolean("TRACK_TEST_DATA"));
                partData.setPartFolderLink(rs.getString("PART_FOLDER_LINK"));
                partData.setPartDescription(rs.getString("PART_DESCRIPTION"));
                partData.setCustomField1(rs.getString("CUSTOM_FIELD_1"));
                partData.setCustomField2(rs.getString("CUSTOM_FIELD_2"));
                partData.setCustomField3(rs.getString("CUSTOM_FIELD_3"));
                partData.setCustomField4(rs.getString("CUSTOM_FIELD_4"));
                partData.setCustomField5(rs.getString("CUSTOM_FIELD_5"));
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
