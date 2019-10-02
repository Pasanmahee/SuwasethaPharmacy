/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2019.1.6
 */
public class AdminNewUsernamePass_Models {

    String oldUsername;
    String oldPassword;
    String newUsername;
    String newPassword;
    String tableDetails;

    public AdminNewUsernamePass_Models() {

    }

    public void setoldUsername(String getoldUsername) {

        this.oldUsername = getoldUsername;

    }

    public void setTableDetails(String getTableDetails) {
        this.tableDetails = getTableDetails;

    }

    public String getTableDetails() {
        return this.tableDetails;

    }

    public void setoldPassword(String getoldPassword) {

        this.oldPassword = getoldPassword;

    }

    public String getoldUsername() {

        return this.oldUsername;
    }

    public String getoldPassword() {

        return this.oldPassword;
    }

    public void setnewUsername(String getnewUsername) {

        this.newUsername = getnewUsername;

    }

    public void setnewPassword(String getnewPassword) {

        this.newPassword = getnewPassword;

    }

    public String getnewUsername() {

        return this.newUsername;
    }

    public String getnewPassword() {

        return this.newPassword;
    }

}
