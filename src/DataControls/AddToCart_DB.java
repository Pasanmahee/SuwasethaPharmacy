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
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import suwasetha_pharmacy.DataBaseConnection;
import Models.AddToCart_Models;

public class AddToCart_DB {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public AddToCart_DB() {
        conn = DataBaseConnection.getconnection();
    }

    public ResultSet loadAddToCartTable(AddToCart_Models objAddToCart_Models) {
        try {
            String sql = "select * from " + objAddToCart_Models.getAddToCartDetails() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public int insertAddToCart(AddToCart_Models objAddToCart_Models) {
        try {

            String sql = "insert into add_to_cart (Cart_ID,Drug_name,Brand_name,Selling_price,Quantity)values (" + objAddToCart_Models.getCartID() + ",'" + objAddToCart_Models.getDrugName() + "','" + objAddToCart_Models.getBrandName() + "'," + objAddToCart_Models.getSellingPrice() + "," + objAddToCart_Models.getQuantity() + ")";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int insertAddToCartDiscountandFinaleAmount(AddToCart_Models objAddToCart_Models) {
        try {

            String sql = "insert into add_to_cart (Cart_ID,Discount_amount,Finale_amount)values (" + objAddToCart_Models.getCartID() + "," + objAddToCart_Models.getDiscountAmount() + "," + objAddToCart_Models.getFinaleAmount() + ")";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int deleteAddToCart(AddToCart_Models objAddToCart_Models) {
        try {
            String sql = "delete from add_to_cart where Cart_ID= " + objAddToCart_Models.getCartID() + "";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet getLastAddToCartID(AddToCart_Models objAddToCart_Models) {

        try {

            String sql = "SELECT * FROM add_to_cart WHERE Cart_ID=(SELECT MAX(" + objAddToCart_Models.getColumnDetails() + ") FROM add_to_cart)";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;

    }

    public ResultSet getSum(AddToCart_Models objAddToCart_Models) {

        try {
            String sql = "select sum(" + objAddToCart_Models.getColumnDetails() + ")from add_to_cart ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;
    }

    public int deleteAll(AddToCart_Models objAddToCart_Models) {

        try {
            String sql = "delete from " + objAddToCart_Models.getColumnDetails() + "";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public JasperDesign billPrint(AddToCart_Models objAddToCart_Models) {
        try {
            JasperDesign jd = JRXmlLoader.load("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\Reports\\Bill.jrxml");
            String sql = "select * from " + objAddToCart_Models.getAddToCartDetails() + " LIMIT 1, 100";
            JRDesignQuery newQuaery = new JRDesignQuery();
            newQuaery.setText(sql);
            jd.setQuery(newQuaery);

            return jd;

        } catch (Exception e) {
        }

        return null;

    }

}
