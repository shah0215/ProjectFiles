package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team23.prototype1.model.BomModel;

/**
 * 
 * @author Himani
 *
 */
public class BomDao extends DatabaseConnectivity {
    /**
     * This arrayList stores the BomModel Objects from the database with information
     * stored with each row
     */
    public static ArrayList<BomModel> bomData = new ArrayList<>();

    /**
     * Adding data to database
     * 
     * @param obj
     */
    public static void addData(BomModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`bom` (`PARENT_PART_NUMBER`, `CHILD_PART_QUANTITY`) VALUES ('"
                            + obj.getParentPartNumber() + "', '" + obj.getChildPartTextLink() + "');");

            addStmt.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    /**
     * Getting list of BomModel objects in sorted order by latest record on top
     * 
     * @return
     */
    public static ArrayList<BomModel> sortByNewest() {

        ArrayList<BomModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM BOM where IS_DELETED = false order by CREATED DESC;");

            while (rs.next()) {

                BomModel partData = new BomModel();

                partData.setParentPartNumber(rs.getString("PARENT_PART_NUMBER"));
                partData.setChildPartTextLink(rs.getString("CHILD_PART_QUANTITY"));
                sorted.add(partData);
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
     * Getting list of BomModel objects in sorted order by ondest record on top
     * 
     * @return
     */
    public static ArrayList<BomModel> sortByOldest() {

        ArrayList<BomModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM BOM where IS_DELETED = false order by CREATED ASC;");

            while (rs.next()) {

                BomModel partData = new BomModel();

                partData.setParentPartNumber(rs.getString("PARENT_PART_NUMBER"));
                partData.setChildPartTextLink(rs.getString("CHILD_PART_QUANTITY"));
                sorted.add(partData);
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
     * reads the data and refresh the bomData ArrayList every time
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bom where IS_DELETED = false");
            bomData.clear();
            while (rs.next()) {

                BomModel partData = new BomModel();

                partData.setParentPartNumber(rs.getString("PARENT_PART_NUMBER"));
                partData.setChildPartTextLink(rs.getString("CHILD_PART_QUANTITY"));

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
     * gets all the partTypeIDs
     * 
     * @return arraylist of integer partType IDs
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
     * deletes by parent
     * 
     * @param parent
     */
    public static void deleteByParent(String parent) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`bom` SET `IS_DELETED` = '1' WHERE (`PARENT_PART_NUMBER` = '"
                    + parent + "');\r\n" + "");

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
     * @return arraylist of part IDs as integer
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
     * @return arraylist of rev Ids as integer
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
     * @param index
     * @return getter of object
     */
    public static BomModel getData(int index) {
        return bomData.get(index);
    }

    /**
     * adds the object to the bomData
     * 
     * @param partData2
     */
    public static void setData(BomModel partData2) {
        bomData.add(partData2);
    }

}
