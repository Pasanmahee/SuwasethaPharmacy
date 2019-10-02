/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author P
 */
import Models.Reports_Models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import suwasetha_pharmacy.DataBaseConnection;

public class Reports_DB {

    PreparedStatement pst;
    Connection conn;
    ResultSet rs;

    public Reports_DB() {
        conn = DataBaseConnection.getconnection();

    }

    public JasperDesign monthlyReports(Reports_Models objReports_Models) {
        try {
            JasperDesign jd = JRXmlLoader.load("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\Reports\\MonthlySalesReports.jrxml");
            String sql = "(SELECT * FROM sales WHERE Sale_Date_and_Time>= '" + objReports_Models.getFromDate() + "' AND Sale_Date_and_Time <= '" + objReports_Models.getToDate() + "') UNION (select Sales_ID = null ,sum(Finale_amount),Sale_Date_and_Time = null from sales where  Sale_Date_and_Time>= '" + objReports_Models.getFromDate() + "' AND Sale_Date_and_Time <= '" + objReports_Models.getToDate() + "')";
            JRDesignQuery newQuaery = new JRDesignQuery();
            newQuaery.setText(sql);
            jd.setQuery(newQuaery);

            return jd;

        } catch (Exception e) {
        }

        return null;

    }

    public JasperDesign dailyReports(Reports_Models objReports_Models) {
        try {
            JasperDesign jd = JRXmlLoader.load("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\Reports\\DailySalesReports.jrxml");
            String sql = "(SELECT * FROM sales WHERE Sale_Date_and_Time = '" + objReports_Models.getFromDate() + "') union (select Sales_ID = null ,sum(Finale_amount),Sale_Date_and_Time = null from sales where Sale_Date_and_Time <= '" + objReports_Models.getFromDate() + "')";
            JRDesignQuery newQuaery = new JRDesignQuery();
            newQuaery.setText(sql);
            jd.setQuery(newQuaery);

            return jd;

        } catch (Exception e) {
        }

        return null;

    }

    public JasperDesign expiryDates(Reports_Models objReports_Models) {
        try {
            JasperDesign jd = JRXmlLoader.load("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\Reports\\ExpiryDates.jrxml");
            String sql = "SELECT Drug_name,Brand_name,Expiry_date FROM drug_categories WHERE Expiry_date <= '" + objReports_Models.getToDate() + "'";
            JRDesignQuery newQuaery = new JRDesignQuery();
            newQuaery.setText(sql);
            jd.setQuery(newQuaery);

            return jd;

        } catch (Exception e) {
        }

        return null;

    }

}
