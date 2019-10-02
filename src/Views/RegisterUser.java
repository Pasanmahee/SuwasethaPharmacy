/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author PASANMAHEE 2019.1.6
 */
import Models.Register_Models;
import DataControls.Register_DB;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class RegisterUser extends javax.swing.JFrame {

    /**
     * Creates new form RegisterUser
     */
    String tableName;
    String columnName;

    public RegisterUser() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        this.getRootPane().setDefaultButton(btn_SignUp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_oldUsername1 = new javax.swing.JTextField();
        txt_oldPassword1 = new javax.swing.JPasswordField();
        txt_NewUsername1 = new javax.swing.JTextField();
        txt_newPassword1 = new javax.swing.JPasswordField();
        btn_ChangeUserNamePassword1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_oldUsername2 = new javax.swing.JTextField();
        txt_oldPassword2 = new javax.swing.JPasswordField();
        txt_NewUsername2 = new javax.swing.JTextField();
        txt_newPassword2 = new javax.swing.JPasswordField();
        btn_SignUp = new javax.swing.JButton();
        cmb_TableName = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        txt_oldUsername1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldUsername1.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldUsername1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldUsername1.setText("Old Username");

        txt_oldPassword1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldPassword1.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldPassword1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldPassword1.setText("jPasswordField1");

        txt_NewUsername1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_NewUsername1.setForeground(new java.awt.Color(51, 51, 51));
        txt_NewUsername1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NewUsername1.setText("New Username");

        txt_newPassword1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_newPassword1.setForeground(new java.awt.Color(51, 51, 51));
        txt_newPassword1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_newPassword1.setText("jPasswordField1");

        btn_ChangeUserNamePassword1.setBackground(new java.awt.Color(0, 204, 204));
        btn_ChangeUserNamePassword1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_ChangeUserNamePassword1.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChangeUserNamePassword1.setText("CHANGE");
        btn_ChangeUserNamePassword1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ChangeUserNamePassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChangeUserNamePassword1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/AddNewUser100x100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel3)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(167, 167, 167))
        );

        txt_oldUsername2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldUsername2.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldUsername2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldUsername2.setText("Current Username");

        txt_oldPassword2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_oldPassword2.setForeground(new java.awt.Color(51, 51, 51));
        txt_oldPassword2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_oldPassword2.setText("jPasswordField1");

        txt_NewUsername2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_NewUsername2.setForeground(new java.awt.Color(51, 51, 51));
        txt_NewUsername2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NewUsername2.setText("New Username");

        txt_newPassword2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_newPassword2.setForeground(new java.awt.Color(51, 51, 51));
        txt_newPassword2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_newPassword2.setText("jPasswordField1");

        btn_SignUp.setBackground(new java.awt.Color(0, 204, 204));
        btn_SignUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        btn_SignUp.setText("SIGN UP");
        btn_SignUp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SignUpActionPerformed(evt);
            }
        });

        cmb_TableName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin_login", "login" }));
        cmb_TableName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmb_TableName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Back.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Pharmacy.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_oldPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_oldUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_NewUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(txt_newPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(btn_SignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(cmb_TableName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cmb_TableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_oldUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_oldPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_NewUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btn_ChangeUserNamePassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChangeUserNamePassword1ActionPerformed

    }//GEN-LAST:event_btn_ChangeUserNamePassword1ActionPerformed

    private void btn_SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SignUpActionPerformed

        tableName = cmb_TableName.getSelectedItem().toString();

        String oldUsername = txt_oldUsername2.getText();
        String oldPassword = txt_oldPassword2.getText();
        String newUsername = txt_NewUsername2.getText();
        String newPassword = txt_newPassword2.getText();

        Register_Models objRegister_Models1 = new Register_Models();
        objRegister_Models1.setoldUsername(oldUsername);
        objRegister_Models1.setTableDetails(tableName);

        Register_DB objRegister_DB1 = new Register_DB();
        Boolean rs1 = objRegister_DB1.getOldUsernameDetails(objRegister_Models1);

        Register_Models objRegister_Models2 = new Register_Models();
        objRegister_Models2.setoldPassword(oldPassword);
        objRegister_Models2.setTableDetails(tableName);

        Register_DB objRegister_DB2 = new Register_DB();
        Boolean rs2 = objRegister_DB2.getOldPasswordDetails(objRegister_Models2);
        if (rs1 == false) {
            if (rs2 == false) {
                Register_Models objRegister_Models4 = new Register_Models();
                objRegister_Models4.setnewUsername(newUsername);
                objRegister_Models4.setnewPassword(newPassword);
                objRegister_Models4.setTableDetails(tableName);

                Register_DB objRegister_DB4 = new Register_DB();
                int x = objRegister_DB4.insertUsernamePassword(objRegister_Models4);

                if (x == 1) {

                    JOptionPane.showMessageDialog(null, "User added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Username already exist");
                }
            } else {

            }
        } else {
            {

            }
        }
        Login objLogin = new Login();
        objLogin.setVisible(true);

        this.hide();


    }//GEN-LAST:event_btn_SignUpActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChangeUserNamePassword1;
    private javax.swing.JButton btn_SignUp;
    private javax.swing.JComboBox<String> cmb_TableName;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_NewUsername1;
    private javax.swing.JTextField txt_NewUsername2;
    private javax.swing.JPasswordField txt_newPassword1;
    private javax.swing.JPasswordField txt_newPassword2;
    private javax.swing.JPasswordField txt_oldPassword1;
    private javax.swing.JPasswordField txt_oldPassword2;
    private javax.swing.JTextField txt_oldUsername1;
    private javax.swing.JTextField txt_oldUsername2;
    // End of variables declaration//GEN-END:variables
}
