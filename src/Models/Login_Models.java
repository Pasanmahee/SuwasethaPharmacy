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
public class Login_Models {

    String username;
    String password;

    public Login_Models(String getUsername, String getPassword) {

        this.username = getUsername;
        this.password = getPassword;

    }

    public void setUsername(String getUsername) {

        this.username = getUsername;

    }

    public void setPassword(String getPassword) {

        this.password = getPassword;

    }

    public String getUsername() {

        return this.username;
    }

    public String getPassword() {

        return this.password;
    }

}
