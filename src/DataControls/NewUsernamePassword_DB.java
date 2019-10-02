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
import Models.NewUsernamePassword_Models;
import suwasetha_pharmacy.DataBaseConnection;
import javax.swing.JOptionPane;

public class NewUsernamePassword_DB {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public NewUsernamePassword_DB() {

        conn = DataBaseConnection.getconnection();

    }

    public int insertUsernamePassword(NewUsernamePassword_Models objNewUsernamePassword_Models) {
        try {

            String sql = "insert into login(username,password)values( '" + objNewUsernamePassword_Models.getnewUsername() + "','" + objNewUsernamePassword_Models.getnewPassword() + "')";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public int deleteUsernamePassword(NewUsernamePassword_Models objNewUsernamePassword_Models) {
        try {
            String sql = "delete from login where username = '" + objNewUsernamePassword_Models.getoldUsername() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public Boolean getOldUsernameDetails(NewUsernamePassword_Models objNewUsernamePassword_Models) {

        String oldUsername = objNewUsernamePassword_Models.getoldUsername();

        String sql = "select * from login where username like '%" + oldUsername + "%' ";

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

    public Boolean getOldPasswordDetails(NewUsernamePassword_Models objNewUsernamePassword_Models) {

        String oldPassword = objNewUsernamePassword_Models.getoldPassword();

        String sql = "select * from login where password like '%" + oldPassword + "%' ";

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
