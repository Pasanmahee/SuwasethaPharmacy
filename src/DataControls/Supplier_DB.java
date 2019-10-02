/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Models.Supplier_Models;

import suwasetha_pharmacy.DataBaseConnection;

/**
 *
 * @author PASANMAHEE 2018.12.21
 */
public class Supplier_DB {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public Supplier_DB() {
        conn = DataBaseConnection.getconnection();
    }

    public int insertSupplier(Supplier_Models objSupplier_Models) {
        try {

            String sql = "insert into supplier (NIC,Supplier_name,Email,Business_name,Telephone_no,Working_history,Join_date,Rating,Image)values('" + objSupplier_Models.getSupplierNIC() + "','" + objSupplier_Models.getSupplierName() + "','" + objSupplier_Models.getEmail() + "','" + objSupplier_Models.getBusinessName() + "','" + objSupplier_Models.getTelephoneNo() + "','" + objSupplier_Models.getWorkingHistory() + "','" + objSupplier_Models.getJoinDate() + "'," + objSupplier_Models.getRating() + ", ? )";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objSupplier_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Duplicate Supplier NIC");
        }
        return 0;

    }

    public int updateSupplier(Supplier_Models objSupplier_Models) {
        try {
            String sql = "update supplier set  Supplier_name='" + objSupplier_Models.getSupplierName() + "',Email='" + objSupplier_Models.getEmail() + "',Business_name='" + objSupplier_Models.getBusinessName() + "',Telephone_no='" + objSupplier_Models.getTelephoneNo() + "',Working_history='" + objSupplier_Models.getWorkingHistory() + "',Join_Date='" + objSupplier_Models.getJoinDate() + "',Rating=" + objSupplier_Models.getRating() + " where NIC='" + objSupplier_Models.getSupplierNIC() + "'";
            pst = conn.prepareStatement(sql);
            //pst.setBytes(1, objSupplier_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }
    
      public int updateImage(Supplier_Models objSupplier_Models) {
        try {
            String sql = "update supplier set  Image = ? " + " where NIC='" + objSupplier_Models.getSupplierNIC() + "'";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objSupplier_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }

    public int deleteSupplier(Supplier_Models objSupplier_Models) {
        try {
            String sql = "delete from supplier where NIC='" + objSupplier_Models.getSupplierNIC() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet loadSupplierTable(Supplier_Models objSupplier_Models) {
        try {
            String sql = "select NIC,Supplier_name,Email,Business_name,Telephone_no,Working_history,Join_date,Rating from " + objSupplier_Models.getSupplierDetails() + "";
            pst = conn.prepareCall(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet loadSupplierTableID(Supplier_Models objSupplier_Models) {
        try {
            String sql = "select * from supplier where NIC='" + objSupplier_Models.getSupplierNIC() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;
    }

    public ResultSet getSearchDetails(Supplier_Models objSupplier_Models) {
        String sql = null;
        String nic = objSupplier_Models.getSupplierNIC();
        String name = objSupplier_Models.getSupplierName();
        String businessName = objSupplier_Models.getBusinessName();

        if (nic != null) {
            sql = "select * from supplier where NIC like '%" + nic + "%' ";
        } else if (name != null) {
            sql = "select * from suppleir where Supplier_name  like '%" + name + "%'";

        } else {
            sql = "select * from supplier where Business_name  like '%" + businessName + "%'";
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

    public ResultSet loadImage(Supplier_Models objSupplier_Models) {
        try {
            String sql = "select Image from supplier where NIC='" + objSupplier_Models.getSupplierNIC() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

}
