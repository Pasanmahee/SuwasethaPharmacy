/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author PASANMAHEE 2019.1.6
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Models.AdminNewUsernamePass_Models;
import suwasetha_pharmacy.DataBaseConnection;
import javax.swing.JOptionPane;

public class AdminNewUsernamePass_DB {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public AdminNewUsernamePass_DB() {

        conn = DataBaseConnection.getconnection();

    }

    public int insertUsernamePassword(AdminNewUsernamePass_Models objAdminNewUsernamePass_Models) {
        try {

            String sql = "insert into admin_login(username,password)values( '" + objAdminNewUsernamePass_Models.getnewUsername() + "','" + objAdminNewUsernamePass_Models.getnewPassword() + "')";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int deleteSales(AdminNewUsernamePass_Models objAdminNewUsernamePass_Models) {
        try {
            String sql = "delete from admin_login where username = '" + objAdminNewUsernamePass_Models.getoldUsername() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public Boolean getOldUsernameDetails(AdminNewUsernamePass_Models objAdminNewUsernamePass_Models) {

        String oldUsername = objAdminNewUsernamePass_Models.getoldUsername();

        String sql = "select * from admin_login where username like '%" + oldUsername + "%' ";

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            //return rs;
            try {
                rs.next();
                return rs.getBoolean(1);

            } finally {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong Username");
        }
        return null;

    }

    public Boolean getOldPasswordDetails(AdminNewUsernamePass_Models objAdminNewUsernamePass_Models) {

        String oldPassword = objAdminNewUsernamePass_Models.getoldPassword();

        String sql = "select * from admin_login where password like '%" + oldPassword + "%' ";

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            try {
                rs.next();
                return rs.getBoolean(1);

            } finally {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong Password");
        }
        return null;

    }

}
