/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author PASANMAHEE 2018.12.25
 */
import Models.NewUsernamePassword_Models;
import DataControls.NewUsernamePassword_DB;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class NewUsernamePassword extends javax.swing.JFrame {

    /**
     * Creates new form NewUsernamePassword
     */
    String tableName;
    String columnName;
    
    public NewUsernamePassword() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        this.getRootPane().setDefaultButton(btn_ChangeUserNamePassword);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_NewUsername = new javax.swing.JTextField();
        txt_newPassword = new javax.swing.JPasswordField();
        btn_ChangeUserNamePassword = new javax.swing.JButton();
        txt_oldUsername = new javax.swing.JTextField();
        txt_oldPassword = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Signin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(126, 126, 126))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(171, 171, 171))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Pharmacy.png"))); // NOI18N

        txt_username.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(51, 51, 51));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setText("USERNAME");

        txt_password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(51, 51, 51));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setText("jPasswordField1");

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SIGN IN");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Change username and password");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Login100x100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(126, 126, 126))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(171, 171, 171))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Pharmacy.png"))); // NOI18N

        txt_NewUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_NewUsername.setForeground(new java.awt.Color(51, 51, 51));
        txt_NewUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NewUsername.setText("New Username");

        txt_newPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_newPassword.setForeground(new java.awt.Color(51, 51, 51));
        txt_newPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_newPassword.setText("jPasswordField1");

        btn_ChangeUserNamePassword.setBackground(new java.awt.Color(0, 204, 204));
        btn_ChangeUserNamePassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_ChangeUserNamePassword.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChangeUserNamePassword.setText("CHANGE");
        btn_ChangeUserNamePassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ChangeUserNamePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChangeUserNamePasswordActionPerformed(evt);
            }
        });

        txt_oldUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldUsername.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldUsername.setText("Old Username");

        txt_oldPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldPassword.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldPassword.setText("jPasswordField1");

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Back.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ChangeUserNamePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_NewUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_oldUsername)
                            .addComponent(txt_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(788, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(12, 12, 12)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_oldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txt_NewUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_ChangeUserNamePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_ChangeUserNamePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChangeUserNamePasswordActionPerformed
        
        tableName = "login";
        columnName = "username";
        
        String oldUsername = txt_oldUsername.getText();
        String oldPassword = txt_oldPassword.getText();
        String newUsername = txt_NewUsername.getText();
        String newPassword = txt_newPassword.getText();
        
        NewUsernamePassword_Models objNewUsernamePassword_Models1 = new NewUsernamePassword_Models();
        objNewUsernamePassword_Models1.setoldUsername(oldUsername);
        
        NewUsernamePassword_DB objNewUsernamePassword_DB1 = new NewUsernamePassword_DB();
        Boolean rs1 = objNewUsernamePassword_DB1.getOldUsernameDetails(objNewUsernamePassword_Models1);
        
        NewUsernamePassword_Models objNewUsernamePassword_Models2 = new NewUsernamePassword_Models();
        objNewUsernamePassword_Models2.setoldPassword(oldPassword);
        
        NewUsernamePassword_DB objNewUsernamePassword_DB2 = new NewUsernamePassword_DB();
        Boolean rs2 = objNewUsernamePassword_DB2.getOldPasswordDetails(objNewUsernamePassword_Models2);
        if (rs1 == false) {
            if (rs2 == false) {
                NewUsernamePassword_Models objNewUsernamePassword_Models4 = new NewUsernamePassword_Models();
                objNewUsernamePassword_Models4.setnewUsername(newUsername);
                objNewUsernamePassword_Models4.setnewPassword(newPassword);
                
                NewUsernamePassword_DB objNewUsernamePassword_DB4 = new NewUsernamePassword_DB();
                int x = objNewUsernamePassword_DB4.insertUsernamePassword(objNewUsernamePassword_Models4);
                
                if (x == 1) {
                    
                    NewUsernamePassword_Models objNewUsernamePassword_Models3 = new NewUsernamePassword_Models();
                    objNewUsernamePassword_Models3.setoldUsername(oldUsername);
                    
                    NewUsernamePassword_DB objNewUsernamePassword_DB3 = new NewUsernamePassword_DB();
                    int y = objNewUsernamePassword_DB3.deleteUsernamePassword(objNewUsernamePassword_Models3);
                    
                    if (y == 1) {
                        
                        JOptionPane.showMessageDialog(null, "Username and Password changed successfull ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username and Password not changed ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exist");
                }
            } else {
            }
            
        } else {
            
        }
        
        Login objLogin = new Login();
        objLogin.setVisible(true);
        
        this.hide();
        

    }//GEN-LAST:event_btn_ChangeUserNamePasswordActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login objLogin = new Login();
        objLogin.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewUsernamePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUsernamePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUsernamePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUsernamePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUsernamePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChangeUserNamePassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txt_NewUsername;
    private javax.swing.JPasswordField txt_newPassword;
    private javax.swing.JPasswordField txt_oldPassword;
    private javax.swing.JTextField txt_oldUsername;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}