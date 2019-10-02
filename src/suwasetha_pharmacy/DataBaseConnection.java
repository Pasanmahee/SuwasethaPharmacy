/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suwasetha_pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author P
 */
public class DataBaseConnection {
    
     public static Connection getconnection() {
        try {

            String url = "jdbc:mysql://localhost:3306/suwasetha_pharmacy?useSSL=false";
            String username = "root";
            String pass = "";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Success");
            return conn;

        } catch (Exception e) {
        }
        return null;
    
    
    
}
}
