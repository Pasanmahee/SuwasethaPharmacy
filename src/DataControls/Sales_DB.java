/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author PASANMAHEE 2018.12.27
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Models.Sales_Models;
import suwasetha_pharmacy.DataBaseConnection;

public class Sales_DB {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public Sales_DB() {
        conn = DataBaseConnection.getconnection();

    }

    public ResultSet loadSalesTable(Sales_Models objSales_Models) {
        try {
            String sql = "select * from " + objSales_Models.getSalesDetails() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public int insertSales(Sales_Models objSales_Models) {
        try {

            String sql = "insert into sales(Sales_ID,Finale_amount,Sale_Date_and_Time)values( '" + objSales_Models.getSaleID() + "'," + objSales_Models.getFinaleAmount() + ",'" + objSales_Models.getDate() + "')";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int updateSales(Sales_Models objSales_Models) {
        try {

            String sql = "update sales set Finale_amount= " + objSales_Models.getFinaleAmount() + ", Date= '" + objSales_Models.getDate() + "' where Sales_ID= '" + objSales_Models.getSaleID() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int deleteSales(Sales_Models objSales_Models) {
        try {
            String sql = "delete from sales where Sales_ID = '" + objSales_Models.getSaleID() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet getLastSaleID(Sales_Models objSales_Models) {

        try {

            String sql = "SELECT * FROM sales WHERE Sales_ID=(SELECT MAX(" + objSales_Models.getColumnDetails() + ") FROM sales)";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;

    }

    public ResultSet getSumFromSales(Sales_Models objSales_Models) {
        try {
            String sql = "select sum(" + objSales_Models.getColumnDetails() + ")from sales ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;

    }
    
  

}
