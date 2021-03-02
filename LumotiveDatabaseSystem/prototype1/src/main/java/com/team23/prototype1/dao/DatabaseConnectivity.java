package com.team23.prototype1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.team23.prototype1.controller.PartTypeController;

public abstract class DatabaseConnectivity {
/**
 * Connection object to connect to database
 */
    static Connection conn = null;
/**
 * Constructor to connect to database
 */
    public DatabaseConnectivity() {

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/PROTOTYPE2?" + "user=root&password=" + PartTypeController.getPassword());

            // Do something with the Connection

            System.out.println("Log 1 : Connected To Database");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        readData();

    }
/**
 * refreshes the data in the child classes
 */
    public void readData() {
        // TODO Auto-generated method stub

    }

}
