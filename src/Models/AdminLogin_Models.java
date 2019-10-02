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
public class AdminLogin_Models {

    String adminUsername;
    String adminPassword;
    int Selection;

    public AdminLogin_Models(String getAdminUsername, String getAdminPassword) {
        this.adminUsername = getAdminUsername;
        this.adminPassword = getAdminPassword;

    }
    
    public AdminLogin_Models(){}

    public void setAdminUsername(String getAdminUsername) {

        this.adminUsername = getAdminUsername;

    }

    public void setSelection(int getSelection) {
        this.Selection = getSelection;

    }

    public void setAdminPassword(String getAdminPassword) {

        this.adminPassword = getAdminPassword();

    }

    public String getAdminUsername() {

        return this.adminUsername;
    }

    public int getSelection() {
        return this.Selection;
    }

    public String getAdminPassword() {

        return this.adminPassword;
    }

}
