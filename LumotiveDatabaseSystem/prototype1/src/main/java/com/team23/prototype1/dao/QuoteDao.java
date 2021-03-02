package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.team23.prototype1.model.QuoteModel;

/**
 * 
 * @author himani
 *
 */
public class QuoteDao extends DatabaseConnectivity {
    /**
     * ArrayList of QuoteModel object carries rows from table Quote Table from
     * database as object
     */
    public static ArrayList<QuoteModel> quoteData = new ArrayList<>();

    /**
     * Inserting Data in Database
     * 
     * @param obj= QuoteModel
     */
    public static void addData(QuoteModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`quote` (`PART_NUMBER`, `SUPPLIER_NAME`, `QUOTE_ID`, `QUOTE_LINK`, `SUPPLIER_LINK`, `QUOTE_DATE`, `SUPPLIER_PN`, `MANUFACTURER_PN`, `CURRENCY`, `QNPL`) VALUES ('"
                            + obj.getPartNumber() + "', '" + obj.getSupplierName()+ "', '" + obj.getQuoteId() + "', '"
                            + obj.getQuoteLink() + "', '" + obj.getSupplierLink() + "', '" + obj.getQuoteDate() + "', '"
                            + obj.getSupplierPn() + "', '" + obj.getManufacturerPn() + "', '" + obj.getCurrency()
                            + "', '" + obj.getQnpl().replace(" ", "") + "'); ");

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
     * @return Sorted list of rows by newest on top
     */
    public static ArrayList<QuoteModel> sortByNewest() {

        ArrayList<QuoteModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM quote where IS_DELETED = false order by CREATED DESC;");

            while (rs.next()) {

                QuoteModel quoteTable = new QuoteModel();

                quoteTable.setPartNumber(rs.getString("PART_NUMBER"));
                quoteTable.setSupplierName(rs.getString("SUPPLIER_NAME"));
                quoteTable.setQuoteId(rs.getString("QUOTE_ID"));
                quoteTable.setQuoteLink(rs.getString("QUOTE_LINK"));
                quoteTable.setSupplierLink(rs.getString("SUPPLIER_LINK"));
                quoteTable.setQuoteDate(rs.getString("QUOTE_DATE"));
                quoteTable.setSupplierPn(rs.getString("SUPPLIER_PN"));
                quoteTable.setManufacturerPn(rs.getString("MANUFACTURER_PN"));
                quoteTable.setCurrency(rs.getString("CURRENCY"));
                quoteTable.setQnpl(rs.getString("QNPL"));
                sorted.add(quoteTable);
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
     * @return Sorted list of rows by oldest on top
     */
    public static ArrayList<QuoteModel> sortByOldest() {

        ArrayList<QuoteModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM quote where IS_DELETED = false order by CREATED ASC;");

            while (rs.next()) {

                QuoteModel quoteTable = new QuoteModel();

                quoteTable.setPartNumber(rs.getString("PART_NUMBER"));
                quoteTable.setSupplierName(rs.getString("SUPPLIER_NAME"));
                quoteTable.setQuoteId(rs.getString("QUOTE_ID"));
                quoteTable.setQuoteLink(rs.getString("QUOTE_LINK"));
                quoteTable.setSupplierLink(rs.getString("SUPPLIER_LINK"));
                quoteTable.setQuoteDate(rs.getString("QUOTE_DATE"));
                quoteTable.setSupplierPn(rs.getString("SUPPLIER_PN"));
                quoteTable.setManufacturerPn(rs.getString("MANUFACTURER_PN"));
                quoteTable.setCurrency(rs.getString("CURRENCY"));
                quoteTable.setQnpl(rs.getString("QNPL"));
                sorted.add(quoteTable);
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
     * refreshes the dataSet and adds to the quoteData ArrayList<QuoteModel>
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM quote where IS_DELETED = false");
            quoteData.clear();
            while (rs.next()) {

                QuoteModel quoteTable = new QuoteModel();

                quoteTable.setPartNumber(rs.getString("PART_NUMBER"));
                quoteTable.setSupplierName(rs.getString("SUPPLIER_NAME"));
                quoteTable.setQuoteId(rs.getString("QUOTE_ID"));
                quoteTable.setQuoteLink(rs.getString("QUOTE_LINK"));
                quoteTable.setSupplierLink(rs.getString("SUPPLIER_LINK"));
                quoteTable.setQuoteDate(rs.getString("QUOTE_DATE"));
                quoteTable.setSupplierPn(rs.getString("SUPPLIER_PN"));
                quoteTable.setManufacturerPn(rs.getString("MANUFACTURER_PN"));
                quoteTable.setCurrency(rs.getString("CURRENCY"));
                quoteTable.setQnpl(rs.getString("QNPL"));

                setData(quoteTable);
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
     * deleting data by PK=Supplier Name
     * 
     * @param supplierName=PK
     */
    public static void deleteBySupplierName(String supplierName) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`quote` SET `IS_DELETED` = '1' WHERE (`SUPPLIER_NAME` = '"
                    + supplierName + "');");

            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public static void updateBySupplierName(String supplierName, QuoteModel obj) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`quote` SET `PART_NUMBER` = '" + obj.getPartNumber()
                    + "', `SUPPLIER_NAME` = '" + obj.getSupplierName() + "', `QUOTE_ID` = '" + obj.getQuoteId()
                    + "', `QUOTE_LINK` = '" + obj.getQuoteLink() + "', `SUPPLIER_LINK` = '" + obj.getSupplierLink()
                    + "', `QUOTE_DATE` = '" + obj.getQuoteDate() + "', `SUPPLIER_PN` = '" + obj.getSupplierPn()
                    + "', `MANUFACTURER_PN` = '" + obj.getManufacturerPn() + "', `CURRENCY` = '" + obj.getCurrency()
                    + "', `QNPL` = '" + obj.getQnpl().replace(" ", "") + "' WHERE (`SUPPLIER_NAME` = '"
                    + supplierName + "');");

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
     * @return list of part type ids
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
     * @return list of part ids
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
     * @return list of rev ids
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
     * getters and setters for quoteData
     * 
     * @param index
     * @return
     */
    public static QuoteModel getData(int index) {
        return quoteData.get(index);
    }

    public static void setData(QuoteModel partData2) {
        quoteData.add(partData2);
    }

}
