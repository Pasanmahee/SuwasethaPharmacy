/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author PASANMAHEE 2019.1.9
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Models.Register_Models;
import suwasetha_pharmacy.DataBaseConnection;
import javax.swing.JOptionPane;

public class Register_DB {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Register_DB() {
        conn = DataBaseConnection.getconnection();

    }

    public int insertUsernamePassword(Register_Models objRegister_Models) {
        try {

            String sql = "insert into " + objRegister_Models.getTableDetails() + " (username,password)values( '" + objRegister_Models.getnewUsername() + "','" + objRegister_Models.getnewPassword() + "')";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {

        }
        return 0;

    }

    public Boolean getOldUsernameDetails(Register_Models objRegister_Models) {

        String oldUsername = objRegister_Models.getoldUsername();

        String sql = "select * from " + objRegister_Models.getTableDetails() + " where username like '%" + oldUsername + "%' ";

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

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

    public Boolean getOldPasswordDetails(Register_Models objRegister_Models) {

        String oldPassword = objRegister_Models.getoldPassword();

        String sql = "select * from " + objRegister_Models.getTableDetails() + " where password like '%" + oldPassword + "%' ";

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
