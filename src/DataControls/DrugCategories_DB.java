/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author PASANMAHEE 2018.12.24
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Models.DrugCategories_Models;
import suwasetha_pharmacy.DataBaseConnection;

public class DrugCategories_DB {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public DrugCategories_DB() {
        conn = DataBaseConnection.getconnection();

    }

    public ResultSet loadDrugCategoryTable(DrugCategories_Models objCategories_Models) {
        try {
            String sql = "select * from " + objCategories_Models.getDrugCategoryDetails() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public ResultSet loadDrugCategoryTableforBillCal(DrugCategories_Models objCategories_Models) {
        try {
            String sql = "select Category,Drug_name,Brand_name,Selling_price,Remain_in_stock,Re_order_value from " + objCategories_Models.getDrugCategoryDetails() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public ResultSet loadDrugCategoryID(DrugCategories_Models objDrugCategories_Models) {
        try {
            String sql = "select * from drug_categories where Drug_name='" + objDrugCategories_Models.getDrugName() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;
    }

    public int insertDrugCategories(DrugCategories_Models objCategories_Models) {
        try {

            String sql = "insert into drug_categories (Category,Drug_name,Brand_name,Supplier_NIC,Buying_price,Selling_price,Remain_in_stock,Re_order_value,Expiry_date,Side_effects)values('" + objCategories_Models.getCategory() + "','" + objCategories_Models.getDrugName() + "','" + objCategories_Models.getBrandName() + "','" + objCategories_Models.getSupplierNIC() + "'," + objCategories_Models.getBuyingPrice() + "," + objCategories_Models.getSellingPrice() + "," + objCategories_Models.getRemainInStock() + "," + objCategories_Models.getReorderValue() + ",'" + objCategories_Models.getExpiryDate() + "','" + objCategories_Models.getSideEffects() + "' )";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Plese fill all the fields");

        }
        return 0;

    }

    public int updateDrugCategories(DrugCategories_Models objCategories_Models) {
        try {
            String sql = "update drug_categories set  Category='" + objCategories_Models.getCategory() + "',Brand_name='" + objCategories_Models.getBrandName() + "',Supplier_NIC='" + objCategories_Models.getSupplierNIC() + "',Buying_price= " + objCategories_Models.getBuyingPrice() + ",Selling_price= " + objCategories_Models.getSellingPrice() + ",Remain_in_stock= " + objCategories_Models.getRemainInStock() + ",Re_order_value= " + objCategories_Models.getReorderValue() + ",Expiry_date='" + objCategories_Models.getExpiryDate() + "',Side_effects ='" + objCategories_Models.getSideEffects() + "' where Drug_name='" + objCategories_Models.getDrugName() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields with expiry date");
        }

        return 0;

    }

    public ResultSet getRemainInStock(DrugCategories_Models objCategories_Models) {
        try {

            String sql = "select Remain_in_stock from drug_categories where Drug_name = '" + objCategories_Models.getDrugName() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

    public int updateRemainInStock(DrugCategories_Models objCategories_Models) {
        try {

            String sql = "update drug_categories set Remain_in_stock= " + objCategories_Models.getRemainInStock() + " where Drug_name='" + objCategories_Models.getDrugName() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
        }
        return 0;
    }

    public int deleteDrugCategories(DrugCategories_Models objCategories_Models) {
        try {
            String sql = "delete from drug_categories where Drug_name='" + objCategories_Models.getDrugName() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet getSearchDetails(DrugCategories_Models objCategories_Models) {
        String sql = null;
        String category = objCategories_Models.getCategory();
        String drugName = objCategories_Models.getDrugName();
        String brandName = objCategories_Models.getBrandName();

        if (category != null) {
            sql = "select * from drug_categories where Category like '%" + category + "%' ";

        } else if (drugName != null) {
            sql = "select * from drug_categories where Drug_name  like '%" + drugName + "%'";

        } else {
            sql = "select * from drug_categories where Brand_name  like '%" + brandName + "%'";

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

}
