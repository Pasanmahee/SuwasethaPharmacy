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
import Models.Login_Models;
import suwasetha_pharmacy.DataBaseConnection;

public class Login_DB {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Login_DB() {

        conn = DataBaseConnection.getconnection();

    }

    public int checkuserlogin(Login_Models objLogin_Models) {
        try {
            String sql = "select * from login where username='" + objLogin_Models.getUsername() + "'and password ='" + objLogin_Models.getPassword() + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {

                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
        }
        return 0;

    }

}
