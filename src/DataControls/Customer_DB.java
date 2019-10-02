/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

import Models.Customer_Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import suwasetha_pharmacy.DataBaseConnection;

/**
 *
 * @author PASANMAHEE 2018.12.19
 */
public class Customer_DB extends Customer_Models  {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public Customer_DB() {
        conn = DataBaseConnection.getconnection();

    }

    public int insertCustomer(Customer_Models objCustomer_Models) {
        try {

            String sql = "insert into customer (Customer_ID,Customer_name,Address,Telephone_No,Email,Age,Loyalty_card_fees,Medical_History,Image)values('" + objCustomer_Models.getCustomerID() + "','" + objCustomer_Models.getCustomerName() + "','" + objCustomer_Models.getAddress() + "','" + objCustomer_Models.getTelephoneNo() + "','" + objCustomer_Models.getEmail() + "'," + objCustomer_Models.getAge() + "," + objCustomer_Models.getLoyaltyCardFees() + ",'" + objCustomer_Models.getMedicalHistory() + "', ? )";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objCustomer_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Duplicate Customer ID");
        }
        return 0;

    }

    public int updateCustomer(Customer_Models objCustomer_Models) {
        try {
            String sql = "update customer set  Customer_Name='" + objCustomer_Models.getCustomerName() + "',Address='" + objCustomer_Models.getAddress() + "',Telephone_No='" + objCustomer_Models.getTelephoneNo() + "',Email='" + objCustomer_Models.getEmail() + "',Age= " + objCustomer_Models.getAge() + ",Loyalty_card_fees= " + objCustomer_Models.getLoyaltyCardFees() + ",Medical_History='" + objCustomer_Models.getMedicalHistory() + "' where Customer_ID='" + objCustomer_Models.getCustomerID() + "'";
            pst = conn.prepareStatement(sql);
            //pst.setBytes(1, objCustomer_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }

    public int updateImage(Customer_Models objCustomer_Models) {
        try {
            String sql = "update customer set  Image = ? " + " where Customer_ID='" + objCustomer_Models.getCustomerID() + "'";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objCustomer_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }

    public int deleteCustomer(Customer_Models objCustomer_Models) {
        try {
            String sql = "delete from customer where Customer_ID='" + objCustomer_Models.getCustomerID() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet loadCustomerTable(Customer_Models objCustomer_Models) {
        try {
            String sql = "select Customer_ID,Customer_name,Address,Telephone_No,Email,Age,Loyalty_card_fees,Medical_History from " + objCustomer_Models.getCustomerDetails() + "";
            pst = conn.prepareCall(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet loadCustomerTableID(Customer_Models objCustomer_Models) {
        try {
            String sql = "select * from customer where Customer_ID='" + objCustomer_Models.getCustomerID() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;
    }

    public ResultSet getSearchDetails(Customer_Models objCustomer_Models) {
        String sql = null;
        String customerID = objCustomer_Models.getCustomerID();
        String customerName = objCustomer_Models.getCustomerName();
        String address = objCustomer_Models.getAddress();
        int age = objCustomer_Models.getAge();
        if (customerID != null) {
            sql = "select * from customer where Customer_ID like '%" + customerID + "%' ";
        } else if (customerName != null) {
            sql = "select * from customer where Customer_Name  like '%" + customerName + "%'";

        } else if (address != null) {
            sql = "select * from customer where Address  like '%" + address + "%'";

        } else {
            sql = "select * from customer where Age  like '%" + age + "%'";

        }

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public ResultSet loadImage(Customer_Models objCustomer_Models) {
        try {
            String sql = "select Image from customer where Customer_ID='" + objCustomer_Models.getCustomerID() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet getLoyaltyCardFees(Customer_Models objCustomer_Models) {
        try {
            String sql = "select Loyalty_card_fees from customer where Customer_ID = " + objCustomer_Models.getCustomerID() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

}
