package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team23.prototype1.model.SnBulkModel;

/**
 * 
 * @author himani
 *
 */
public class SnBulkDao extends DatabaseConnectivity {
    /**
     * ArrayList of SnBulkModel objects carries Data from SNBULK table
     * 
     */
    public static ArrayList<SnBulkModel> snBulkData = new ArrayList<>();

    /**
     * Inserting data in the database
     * 
     * @param obj=SnBulkModel
     */
    public static void addData(SnBulkModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`snbulk` (`PART_NUMBER`, `REV_ID`, `DATE_RECEIVED`, `QUANTITY_RECEIVED`, `SUPPLIER`, `SUPPLIER_PN`, `SUPPLIER_LOT_NUMBER`, `COMMENTS`) VALUES ('"
                            + obj.getPartNumber() + "', '" + obj.getRevId() + "', '" + obj.getDateReceived() + "', '"
                            + obj.getQuantityReceived() + "', '" + obj.getSupplier() + "', '" + obj.getSupplierPn()
                            + "', '" + obj.getSupplierLotNumber() + "', '" + obj.getComments() + "');");

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
     * @return the list of sorted objects by newest on top
     */
    public static ArrayList<SnBulkModel> sortByNewest() {

        ArrayList<SnBulkModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM snbulk where IS_DELETED = false order by CREATED DESC;");

            while (rs.next()) {
                SnBulkModel snBulk = new SnBulkModel();
                snBulk.setId(rs.getString("ID"));
                snBulk.setPartNumber(rs.getString("PART_NUMBER"));
                snBulk.setRevId(rs.getString("REV_ID"));
                snBulk.setDateReceived(rs.getString("DATE_RECEIVED"));
                snBulk.setQuantityReceived(rs.getString("QUANTITY_RECEIVED"));
                snBulk.setSupplier(rs.getString("SUPPLIER"));
                snBulk.setSupplierPn(rs.getString("SUPPLIER_PN"));
                snBulk.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                snBulk.setComments(rs.getString("COMMENTS"));
                sorted.add(snBulk);
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
     * @return list of sorted objects by oldest on top
     */
    public static ArrayList<SnBulkModel> sortByOldest() {

        ArrayList<SnBulkModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SNBULK where IS_DELETED = false order by CREATED ASC;");

            while (rs.next()) {

                SnBulkModel snBulk = new SnBulkModel();
                snBulk.setId(rs.getString("ID"));
                snBulk.setPartNumber(rs.getString("PART_NUMBER"));
                snBulk.setRevId(rs.getString("REV_ID"));
                snBulk.setDateReceived(rs.getString("DATE_RECEIVED"));
                snBulk.setQuantityReceived(rs.getString("QUANTITY_RECEIVED"));
                snBulk.setSupplier(rs.getString("SUPPLIER"));
                snBulk.setSupplierPn(rs.getString("SUPPLIER_PN"));
                snBulk.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                snBulk.setComments(rs.getString("COMMENTS"));
                sorted.add(snBulk);
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
     * refreshes the data and updates the snBulkData list
     * 
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SNBULK where IS_DELETED = false");
            snBulkData.clear();

            while (rs.next()) {

                SnBulkModel snBulk = new SnBulkModel();
                snBulk.setId(rs.getString("ID"));
                snBulk.setPartNumber(rs.getString("PART_NUMBER"));
                snBulk.setRevId(rs.getString("REV_ID"));
                snBulk.setDateReceived(rs.getString("DATE_RECEIVED"));
                snBulk.setQuantityReceived(rs.getString("QUANTITY_RECEIVED"));
                snBulk.setSupplier(rs.getString("SUPPLIER"));
                snBulk.setSupplierPn(rs.getString("SUPPLIER_PN"));
                snBulk.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                snBulk.setComments(rs.getString("COMMENTS"));

                setData(snBulk);
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
     * Deleting row by id=PK
     * 
     * @param id=PK
     */
    public static void deleteById(int id) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`snbulk` SET `IS_DELETED` = '1' WHERE (`ID` = '" + id + "');");

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
     * Updating data by id=PK
     * 
     * @param id=PK
     * @param obj=  snBulkModel
     */
    public static void updateById(int id, SnBulkModel obj) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`snbulk` SET `PART_NUMBER` = '" + obj.getPartNumber() + "',"
                    + " `REV_ID` = '" + obj.getRevId() + "', `DATE_RECEIVED` = '" + obj.getDateReceived() + "',"
                    + " `QUANTITY_RECEIVED` = '" + obj.getQuantityReceived() + "', `SUPPLIER` = '" + obj.getSupplier()
                    + "'," + " `SUPPLIER_PN` = '" + obj.getSupplierPn() + "', `SUPPLIER_LOT_NUMBER` = '"
                    + obj.getSupplierLotNumber() + "', `COMMENTS` = '" + obj.getComments() + "' WHERE (`ID` = '" + id
                    + "');");

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
     * @return list of partIds
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
     * 
     * @return list of Rev Ids
     */
    public static ArrayList<Integer> revIds() {

        ArrayList<Integer> revIds = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT rev_id FROM part where IS_DELETED = false");

            while (rs.next()) {

                revIds.add(rs.getInt("REV_ID"));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return revIds;

    }

    /**
     * 
     * @return List of suppliers
     */
    public static ArrayList<String> suppliers() {

        ArrayList<String> suppliers = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUPPLIER_NAME FROM PROTOTYPE2.QUOTE where IS_DELETED = false");

            while (rs.next()) {

                suppliers.add((rs.getString("SUPPLIER_NAME")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return suppliers;

    }

    /**
     * 
     * @return list of supplier Pns
     */
    public static ArrayList<String> supplierPns() {

        ArrayList<String> supplierPns = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUPPLIER_PN FROM PROTOTYPE2.QUOTE where IS_DELETED = false");

            while (rs.next()) {

                supplierPns.add((rs.getString("SUPPLIER_PN")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return supplierPns;

    }

    /**
     * 
     * getters and setters for snBulkData
     * 
     * 
     * @param index
     * @return
     */
    public static SnBulkModel getData(int index) {
        return snBulkData.get(index);
    }

    public static void setData(SnBulkModel projectData2) {
        snBulkData.add(projectData2);
    }

}
