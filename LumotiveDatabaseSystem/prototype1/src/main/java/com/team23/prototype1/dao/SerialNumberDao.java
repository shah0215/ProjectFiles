package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team23.prototype1.model.SerialNumberModel;

/**
 * 
 * @author himani
 *
 */
public class SerialNumberDao extends DatabaseConnectivity {
    /**
     * ArrayList of SerialNumberModel objects carries data from Serial Number table
     * as rows
     */
    public static ArrayList<SerialNumberModel> serialNumberList = new ArrayList<>();

    /**
     * 
     * Inserting data in the Tables
     * 
     * @param obj=SerialNumberModel
     */
    public static void addData(SerialNumberModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`serial_number` (`PART_NUMBER`, `REV_ID`, `SERIAL_NUMBER`, `DATE_RECEIVED`, `SUPPLIER_LOT_NUMBER`, `SUPPLIER_SERIAL_NUMBER`, `STATUS`, `LOCATION`, `CUSTOMER`, `TEST_DATA`, `COMMENTS`) VALUES ('"
                            + obj.getPartNumber() + "', '" + obj.getRevId() + "', '" + obj.getSerialNumber() + "', '"
                            + obj.getDateReceived() + "', '" + obj.getSupplierLotNumber() + "', '"
                            + obj.getSupplierSerialNumber() + "', '" + obj.getStatus() + "', '" + obj.getLocation()
                            + "', '" + obj.getCustomer() + "', '" + obj.getTestData() + "', '" + obj.getComments()
                            + "');");

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
     * @return list of sorted objects by newest record on top
     */
    public static ArrayList<SerialNumberModel> sortByNewest() {

        ArrayList<SerialNumberModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SERIAL_NUMBER where IS_DELETED = false order by CREATED DESC;");

            while (rs.next()) {

                SerialNumberModel sn = new SerialNumberModel();
                sn.setId(rs.getString("ID"));
                sn.setPartNumber(rs.getString("PART_NUMBER"));
                sn.setRevId(rs.getString("REV_ID"));

                String SerialNumber = String.format("%07d", Integer.valueOf(rs.getString("ID")));

                sn.setSerialNumber(rs.getString("SERIAL_NUMBER") + "-" + SerialNumber);
                sn.setDateReceived(rs.getString("DATE_RECEIVED"));

                sn.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                sn.setSupplierSerialNumber(rs.getString("SUPPLIER_SERIAL_NUMBER"));
                sn.setStatus(rs.getString("STATUS"));
                sn.setLocation(rs.getString("LOCATION"));
                sn.setCustomer(rs.getString("CUSTOMER"));
                sn.setTestData(rs.getString("TEST_DATA"));
                sn.setComments(rs.getString("COMMENTS"));
                sorted.add(sn);
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
     * @return list of sorted objects by oldest record on top
     */
    public static ArrayList<SerialNumberModel> sortByOldest() {

        ArrayList<SerialNumberModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SERIAL_NUMBER where IS_DELETED = false order by CREATED ASC;");

            while (rs.next()) {

                SerialNumberModel sn = new SerialNumberModel();
                sn.setId(rs.getString("ID"));
                sn.setPartNumber(rs.getString("PART_NUMBER"));
                sn.setRevId(rs.getString("REV_ID"));

                String SerialNumber = String.format("%07d", Integer.valueOf(rs.getString("ID")));

                sn.setSerialNumber(rs.getString("SERIAL_NUMBER") + "-" + SerialNumber);
                sn.setDateReceived(rs.getString("DATE_RECEIVED"));

                sn.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                sn.setSupplierSerialNumber(rs.getString("SUPPLIER_SERIAL_NUMBER"));
                sn.setStatus(rs.getString("STATUS"));
                sn.setLocation(rs.getString("LOCATION"));
                sn.setCustomer(rs.getString("CUSTOMER"));
                sn.setTestData(rs.getString("TEST_DATA"));
                sn.setComments(rs.getString("COMMENTS"));
                sorted.add(sn);
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
     * refreshes the data in the Arraylist of serialNumberList
     * 
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SERIAL_NUMBER where IS_DELETED = false");
            serialNumberList.clear();

            while (rs.next()) {

                SerialNumberModel sn = new SerialNumberModel();
                sn.setId(rs.getString("ID"));
                sn.setPartNumber(rs.getString("PART_NUMBER"));
                sn.setRevId(rs.getString("REV_ID"));

                String SerialNumber = String.format("%07d", Integer.valueOf(rs.getString("ID")));

                sn.setSerialNumber(rs.getString("SERIAL_NUMBER") + "-" + SerialNumber);
                sn.setDateReceived(rs.getString("DATE_RECEIVED"));

                sn.setSupplierLotNumber(rs.getString("SUPPLIER_LOT_NUMBER"));
                sn.setSupplierSerialNumber(rs.getString("SUPPLIER_SERIAL_NUMBER"));
                sn.setStatus(rs.getString("STATUS"));
                sn.setLocation(rs.getString("LOCATION"));
                sn.setCustomer(rs.getString("CUSTOMER"));
                sn.setTestData(rs.getString("TEST_DATA"));
                sn.setComments(rs.getString("COMMENTS"));

                setData(sn);
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
     * Deleting row by id=PK
     * 
     * @param id=PK
     */
    public static void deleteById(int id) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "UPDATE `prototype2`.`serial_number` SET `IS_DELETED` = '1' WHERE (`ID` = '" + id + "');");

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
     * Updating by PK=id
     * 
     * @param id=PK
     * @param obj=SerialNumberModel
     */
    public static void updateById(int id, SerialNumberModel obj) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`serial_number`" + " SET `PART_NUMBER` = '" + obj.getPartNumber()
                    + "', `REV_ID` = '" + obj.getRevId() + "'," + " `SERIAL_NUMBER` = '" + obj.getSerialNumber()
                    + "', `DATE_RECEIVED` = '" + obj.getDateReceived() + "'," + " `SUPPLIER_LOT_NUMBER` = '"
                    + obj.getSupplierLotNumber() + "', `SUPPLIER_SERIAL_NUMBER` = '" + obj.getSupplierSerialNumber()
                    + "'," + " `STATUS` = '" + obj.getStatus() + "', `LOCATION` = '" + obj.getLocation()
                    + "', `CUSTOMER` = '" + obj.getCustomer() + "'," + " `TEST_DATA` = '" + obj.getTestData()
                    + "', `COMMENTS` = '" + obj.getComments() + "' WHERE (`ID` = '" + id + "');");

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
     * @return list of Part Ids
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
     * @return list of Supplier Lot Number
     */
    public static ArrayList<String> supplierLotNumber() {

        ArrayList<String> lotList = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SUPPLIER_LOT_NUMBER FROM PROTOTYPE2.SNBULK where IS_DELETED = false");

            while (rs.next()) {

                lotList.add((rs.getString("SUPPLIER_LOT_NUMBER")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return lotList;

    }

    /**
     * Getting Part code by Part Number
     * 
     * @param partNumber
     * @return
     */
    public static String getPartCodes(String partNumber) {

        String s = "";
        Statement stmt = null;
        ResultSet rs = null;

        String[] pn = partNumber.split("-");

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PART_CODE FROM PROTOTYPE2.PART where IS_DELETED = false and PART_TYPE_ID ='"
                    + pn[0] + "' and PART_ID= '" + pn[1] + "';");

            while (rs.next()) {

                s = ((rs.getString("PART_CODE")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return s;

    }

    /**
     * 
     * @return list of supplier PNs
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
     * Getters and setters for serialNumberList
     * 
     * @param index
     * @return
     */
    public static SerialNumberModel getData(int index) {
        return serialNumberList.get(index);
    }

    public static void setData(SerialNumberModel projectData2) {
        serialNumberList.add(projectData2);
    }

}
