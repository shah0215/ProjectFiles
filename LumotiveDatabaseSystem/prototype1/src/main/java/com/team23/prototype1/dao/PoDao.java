package com.team23.prototype1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.team23.prototype1.model.PoModel;
import com.team23.prototype1.model.QNPL;

/**
 * 
 * @author himani
 *
 */
public class PoDao extends DatabaseConnectivity {
    /**
     * ArrayList<poData> podata to store PoModel objects with infromation of each
     * row from database
     */
    public static ArrayList<PoModel> poData = new ArrayList<>();

    public static void addData(PoModel obj) {

        Statement addStmt = null;

        try {
            addStmt = conn.createStatement();

            addStmt.executeUpdate(
                    "INSERT INTO `prototype2`.`po` (`PART_NUMBER`, `SUPPLIER`, `QUOTE_ID`, `PO_DATE`, `ORDER_QUANTITY`, `STATUS`, `COMMENTS`) VALUES ('"
                            + obj.getPartNumber() + "', '" + obj.getSupplier() + "', '" + obj.getQuoteId() + "', '"
                            + obj.getPodate() + "', '" + obj.getOrderQuantity() + "', '" + obj.getStatus() + "', '"
                            + obj.getComments() + "');");

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
     * @return ArrrayList of sorted data by newest on top
     */
    public static ArrayList<PoModel> sortByNewest() {

        ArrayList<PoModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM PO where IS_DELETED = false order by CREATED DESC;");

            
            while (rs.next()) {

                PoModel poReader = new PoModel();
                poReader.setId(rs.getString("ID"));
                poReader.setPartNumber(rs.getString("PART_NUMBER"));
                poReader.setSupplier(rs.getString("SUPPLIER"));
                poReader.setQuoteId(rs.getString("QUOTE_ID"));
                poReader.setPodate(rs.getString("PO_DATE"));
                poReader.setOrderQuantity(rs.getString("ORDER_QUANTITY"));
                poReader.setStatus(rs.getString("STATUS"));
                poReader.setComments(rs.getString("COMMENTS"));
                sorted.add(poReader);
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
     * @return ArrrayList of sorted data by oldest on top
     */
    public static ArrayList<PoModel> sortByOldest() {

        ArrayList<PoModel> sorted = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM PO where IS_DELETED = false order by CREATED ASC;");

            
            while (rs.next()) {

                PoModel poReader = new PoModel();
                poReader.setId(rs.getString("ID"));
                poReader.setPartNumber(rs.getString("PART_NUMBER"));
                poReader.setSupplier(rs.getString("SUPPLIER"));
                poReader.setQuoteId(rs.getString("QUOTE_ID"));
                poReader.setPodate(rs.getString("PO_DATE"));
                poReader.setOrderQuantity(rs.getString("ORDER_QUANTITY"));
                poReader.setStatus(rs.getString("STATUS"));
                poReader.setComments(rs.getString("COMMENTS"));
                sorted.add(poReader);
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
     * refreshes the ArrayList with updated data
     */
    @Override
    public void readData() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM po where IS_DELETED = false");
            poData.clear();
           
            while (rs.next()) {

                PoModel poReader = new PoModel();
                poReader.setId(rs.getString("ID"));
                poReader.setPartNumber(rs.getString("PART_NUMBER"));
                poReader.setSupplier(rs.getString("SUPPLIER"));
                poReader.setQuoteId(rs.getString("QUOTE_ID"));
                poReader.setPodate(rs.getString("PO_DATE"));
                poReader.setOrderQuantity(rs.getString("ORDER_QUANTITY"));
                poReader.setStatus(rs.getString("STATUS"));
                poReader.setComments(rs.getString("COMMENTS"));

                setData(poReader);
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
     * deleting by PK=id
     * 
     * @param id=PK
     */
    public static void deleteById(int id) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`po` SET `IS_DELETED` = '1' WHERE (`ID` = '" + id + "');");

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
     * updating by id=PK
     * 
     * @param id=PK
     * @param obj=PoModel
     */
    public static void updateById(int id, PoModel obj) {

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `prototype2`.`po` SET `PART_NUMBER` = '" + obj.getPartNumber()
                    + "', `SUPPLIER` = '" + obj.getSupplier() + "', `PO_DATE` = '" + obj.getPodate()
                    + "', `ORDER_QUANTITY` = '" + obj.getOrderQuantity() + "', `STATUS` = '" + obj.getStatus()
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
     * @return ArrayList with suppliers
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
     * @return ArrayList with Quote Ids
     */
    public static ArrayList<String> quoteIds() {

        ArrayList<String> quoteIds = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT QUOTE_ID FROM PROTOTYPE2.QUOTE where IS_DELETED = false");

           
            while (rs.next()) {

                quoteIds.add((rs.getString("QUOTE_ID")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return quoteIds;

    }

    /**
     * 
     * @return ArrayList with order quantities
     */
    public static ArrayList<String> orderQuantities() {

        ArrayList<String> qnpl = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT QNPL FROM PROTOTYPE2.QUOTE where IS_DELETED = false");

           
            while (rs.next()) {

                qnpl.add((rs.getString("QNPL")));

            }
            stmt.close();
            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        ArrayList<String> quantityList = new ArrayList<>();
        for (int i = 0; i < qnpl.size(); i++) {
            /**
             * 
             * getting the json String and parsing it to QNPL class object
             * 
             */
            Gson gson = new Gson();

            QNPL object = gson.fromJson(qnpl.get(i), QNPL.class);

            for (int j = 0; j < object.getQuantity().size(); j++) {

                if (object.getQuantity().get(j).contentEquals(" ")) {
                    break;
                }

                quantityList.add(object.getQuantity().get(j));

            }

        }

        return quantityList;

    }
/**
 * 
 * @return ArrayList of PartTypeIds
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
 * @return list of PartIds
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
 * @param index getter for Podata
 * @return poData object of given Index
 */
    public static PoModel getData(int index) {
        return poData.get(index);
    }
/**
 * sets the new data to the list
 * @param projectData2
 */
    public static void setData(PoModel projectData2) {
        poData.add(projectData2);
    }

}
