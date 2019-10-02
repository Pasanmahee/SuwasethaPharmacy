/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.JFrame;
import javax.swing.JFrame;
import Models.Supplier_Models;
import DataControls.Supplier_DB;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;
import org.opencv.core.Core;

/**
 *
 * @author PASANMAHEE 2018.12.21
 */
public class Supplier_Views extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    String columnname;
    String tableName;
    String s;//Path that image exists
    int rating;
    byte[] supplierImage;

    /**
     * Creates new form Supplier_Views
     */
    public Supplier_Views() {
        initComponents();
        JFrame frame = new JFrame();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        loadSupplierTable();

    }

    private void loadSupplierTable() {
        tableName = "supplier";

        Supplier_Models objSupplier_Models = new Supplier_Models();
        objSupplier_Models.setSupplierDetails(tableName);

        Supplier_DB objSupplier_DB = new Supplier_DB();
        ResultSet rs = objSupplier_DB.loadSupplierTable(objSupplier_Models);
        try {
            if (rs.next()) {

                tbl_Supplier.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Supplier Table Found");
        }

    }

    private void loadImage() {

        String getSupplierID = txt_SupplierNIC.getText();
        try {

            Supplier_Models objSupplier_Models = new Supplier_Models();
            objSupplier_Models.setSupplierNIC(getSupplierID);
            Supplier_DB objSupplier_DB = new Supplier_DB();
            ResultSet rs = objSupplier_DB.loadImage(objSupplier_Models);

            if (rs.next()) {
                byte[] imgData = rs.getBytes("Image");
                ImageIcon image = new ImageIcon(imgData);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(lbl_SupplierImage.getWidth(), lbl_SupplierImage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                lbl_SupplierImage.setIcon(newImage);

            } else {
              

            }

        } catch (Exception e) {
            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\profilePic.png");
            lbl_SupplierImage.setIcon(image);
        }

    }
//used to browse images fit in the Jlable correctely 

    private ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lbl_SupplierImage.getWidth(), lbl_SupplierImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    private void loadRating() {

        if (rating == 1) {
            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\1.png");
            lbl_Rating.setIcon(image);

            ImageIcon image2 = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating1.png");
            lbl_sliderRating.setIcon(image2);
            jSlider1.setValue(1);

        } else if (rating == 2) {
            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\2.png");
            lbl_Rating.setIcon(image);

            ImageIcon image2 = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating2.png");
            lbl_sliderRating.setIcon(image2);
            jSlider1.setValue(2);

        } else if (rating == 3) {
            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\3.png");
            lbl_Rating.setIcon(image);

            ImageIcon image2 = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating3.png");
            lbl_sliderRating.setIcon(image2);
            jSlider1.setValue(3);

        } else if (rating == 4) {
            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\4.png");
            lbl_Rating.setIcon(image);

            ImageIcon image2 = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating4.png");
            lbl_sliderRating.setIcon(image2);
            jSlider1.setValue(4);

        } else {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\5.png");
            lbl_Rating.setIcon(image);

            ImageIcon image2 = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating5.png");
            lbl_sliderRating.setIcon(image2);
            jSlider1.setValue(5);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        rb_SupplierNIC = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        rb_SupplierName = new javax.swing.JRadioButton();
        rb_BusinessName = new javax.swing.JRadioButton();
        txt_search = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Supplier = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_SupplierImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_AddToSupplier = new javax.swing.JButton();
        btn_UpdateSupplier = new javax.swing.JButton();
        btn_DeleteFromSupplier = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_WorkingHistory = new javax.swing.JTextArea();
        txt_Email = new javax.swing.JTextField();
        txt_TelephoneNo = new javax.swing.JTextField();
        txt_BusinessName = new javax.swing.JTextField();
        txt_Name = new javax.swing.JTextField();
        txt_SupplierNIC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_OpenCamera = new javax.swing.JButton();
        btn_SendEmail = new javax.swing.JButton();
        btn_BrowseImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_Rating = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        lbl_sliderRating = new javax.swing.JLabel();
        btn_UpdateImage = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        buttonGroup1.add(rb_SupplierNIC);
        rb_SupplierNIC.setForeground(new java.awt.Color(255, 255, 255));
        rb_SupplierNIC.setText("Supplier NIC");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Search Supplier details by click on Radio button and type a Keyword in below text field ");

        buttonGroup1.add(rb_SupplierName);
        rb_SupplierName.setForeground(new java.awt.Color(255, 255, 255));
        rb_SupplierName.setText("Supplier Name");

        buttonGroup1.add(rb_BusinessName);
        rb_BusinessName.setForeground(new java.awt.Color(255, 255, 255));
        rb_BusinessName.setText("Business Name");

        txt_search.setBackground(new java.awt.Color(0, 153, 153));
        txt_search.setForeground(new java.awt.Color(0, 0, 0));
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/icons8_Search_31px.png"))); // NOI18N

        tbl_Supplier.setBackground(new java.awt.Color(153, 153, 153));
        tbl_Supplier.setForeground(new java.awt.Color(255, 255, 255));
        tbl_Supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Supplier);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Click on the table, row where you want to edit");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Supplier.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rb_SupplierNIC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_SupplierName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_BusinessName))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_SupplierNIC)
                            .addComponent(rb_SupplierName)
                            .addComponent(rb_BusinessName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(31, 31, 31))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Pharmacy.png"))); // NOI18N

        lbl_SupplierImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/profilePic.png"))); // NOI18N
        lbl_SupplierImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Supplier NIC");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Business Name");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telephone No");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rating");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Join Date");

        btn_AddToSupplier.setBackground(new java.awt.Color(153, 153, 153));
        btn_AddToSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Add.png"))); // NOI18N
        btn_AddToSupplier.setText("ADD");
        btn_AddToSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddToSupplierActionPerformed(evt);
            }
        });

        btn_UpdateSupplier.setBackground(new java.awt.Color(153, 153, 153));
        btn_UpdateSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Update.png"))); // NOI18N
        btn_UpdateSupplier.setText("UPDATE");
        btn_UpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateSupplierActionPerformed(evt);
            }
        });

        btn_DeleteFromSupplier.setBackground(new java.awt.Color(153, 153, 153));
        btn_DeleteFromSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Delete.png"))); // NOI18N
        btn_DeleteFromSupplier.setText("DELETE");
        btn_DeleteFromSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteFromSupplierActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(153, 153, 153));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Clear.png"))); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        txt_WorkingHistory.setBackground(new java.awt.Color(102, 102, 102));
        txt_WorkingHistory.setColumns(20);
        txt_WorkingHistory.setForeground(new java.awt.Color(255, 255, 255));
        txt_WorkingHistory.setRows(5);
        jScrollPane1.setViewportView(txt_WorkingHistory);

        txt_Email.setBackground(new java.awt.Color(102, 102, 102));
        txt_Email.setForeground(new java.awt.Color(255, 255, 255));

        txt_TelephoneNo.setBackground(new java.awt.Color(102, 102, 102));
        txt_TelephoneNo.setForeground(new java.awt.Color(255, 255, 255));

        txt_BusinessName.setBackground(new java.awt.Color(102, 102, 102));
        txt_BusinessName.setForeground(new java.awt.Color(255, 255, 255));

        txt_Name.setBackground(new java.awt.Color(102, 102, 102));
        txt_Name.setForeground(new java.awt.Color(255, 255, 255));

        txt_SupplierNIC.setBackground(new java.awt.Color(102, 102, 102));
        txt_SupplierNIC.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Working History");

        btn_OpenCamera.setBackground(new java.awt.Color(153, 153, 153));
        btn_OpenCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/cam.png"))); // NOI18N
        btn_OpenCamera.setText("Open Camera");
        btn_OpenCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OpenCameraActionPerformed(evt);
            }
        });

        btn_SendEmail.setBackground(new java.awt.Color(153, 153, 153));
        btn_SendEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/SendMail.png"))); // NOI18N
        btn_SendEmail.setText("Send Email");
        btn_SendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendEmailActionPerformed(evt);
            }
        });

        btn_BrowseImage.setBackground(new java.awt.Color(153, 153, 153));
        btn_BrowseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Browse.png"))); // NOI18N
        btn_BrowseImage.setText("Browse Image");
        btn_BrowseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BrowseImageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUPPLIER PORTAL");

        lbl_Rating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/1.png"))); // NOI18N

        jSlider1.setMaximum(5);
        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        lbl_sliderRating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Rating1.png"))); // NOI18N

        btn_UpdateImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Update.png"))); // NOI18N
        btn_UpdateImage.setText("UPDATE IMG");
        btn_UpdateImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateImageActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(102, 102, 102));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_SupplierNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(lbl_sliderRating)
                                                .addGap(23, 23, 23))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                                .addComponent(btn_SendEmail))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_BusinessName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(144, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_DeleteFromSupplier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_UpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_AddToSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_TelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addGap(0, 144, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_BrowseImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_UpdateImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_Rating, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(btn_OpenCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_SupplierImage, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_OpenCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(lbl_Rating, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(78, 78, 78)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_BrowseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_UpdateImage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lbl_SupplierImage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_SupplierNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_BusinessName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_sliderRating))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_AddToSupplier)
                            .addComponent(btn_UpdateSupplier)
                            .addComponent(btn_DeleteFromSupplier)
                            .addComponent(btn_clear)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        Supplier_Models objSupplier_Models = new Supplier_Models();
        String value = txt_search.getText();
        Supplier_DB objSupplier_DB = new Supplier_DB();

        if (rb_SupplierNIC.isSelected()) {

            objSupplier_Models.setSupplierNIC(value);
        } else if (rb_SupplierName.isSelected()) {

            objSupplier_Models.setSupplierName(value);
        } else if (rb_BusinessName.isSelected()) {

            objSupplier_Models.setBusinessName(value);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Button before you search");
        }
        ResultSet rs = objSupplier_DB.getSearchDetails(objSupplier_Models);

        tbl_Supplier.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_txt_searchKeyReleased

    private void tbl_SupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SupplierMouseClicked

        int row = tbl_Supplier.getSelectedRow();
        String tableClick = tbl_Supplier.getModel().getValueAt(row, 0).toString();

        Supplier_Models objSupplier_Models = new Supplier_Models();
        objSupplier_Models.setSupplierNIC(tableClick);
        Supplier_DB objSupplier_DB = new Supplier_DB();
        ResultSet rs = objSupplier_DB.loadSupplierTableID(objSupplier_Models);
        try {
            if (rs.next()) {

                txt_SupplierNIC.setText(rs.getString("NIC"));
                txt_BusinessName.setText(rs.getString("Business_name"));
                java.util.Date d = rs.getDate("Join_Date");
                jDateChooser1.setDate(d);
                rating = rs.getInt("Rating");
                txt_Name.setText(rs.getString("Supplier_name"));
                txt_WorkingHistory.setText(rs.getString("Working_history"));
                txt_TelephoneNo.setText(rs.getString("Telephone_no"));
                txt_Email.setText(rs.getString("Email"));

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        loadImage();
        loadRating();
    }//GEN-LAST:event_tbl_SupplierMouseClicked

    private void btn_AddToSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddToSupplierActionPerformed

        try {

            String getSupplierNIC = txt_SupplierNIC.getText();
            String getName = txt_Name.getText();
            String getBusinessName = txt_BusinessName.getText();
            String getTelephoneNo = txt_TelephoneNo.getText();
            String getEmail = txt_Email.getText();
            int getIntRating = jSlider1.getValue();

            java.util.Date d = jDateChooser1.getDate();
            java.sql.Date sqldate = new java.sql.Date(d.getTime());

            String getWorkingHistory = txt_WorkingHistory.getText();
            byte[] getImage = supplierImage;

            Supplier_Models objSupplier_Models = new Supplier_Models(getSupplierNIC, getName, getBusinessName, getTelephoneNo, getEmail, sqldate, getWorkingHistory, getIntRating);
            objSupplier_Models.setImage(getImage);
            Supplier_DB objSupplier_DB = new Supplier_DB();
            int x = objSupplier_DB.insertSupplier(objSupplier_Models);

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Inserted Successfull");

            } else {
                JOptionPane.showMessageDialog(null, "Not Inserted");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");

        }
        loadSupplierTable();
    }//GEN-LAST:event_btn_AddToSupplierActionPerformed

    private void btn_UpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateSupplierActionPerformed
        String getSupplierNIC = txt_SupplierNIC.getText();
        String getName = txt_Name.getText();
        String getBusinessName = txt_BusinessName.getText();
        String getTelephoneNo = txt_TelephoneNo.getText();
        String getEmail = txt_Email.getText();
        int getIntRating = jSlider1.getValue();
        java.util.Date d = jDateChooser1.getDate();
        java.sql.Date sqldate = new java.sql.Date(d.getTime());
        String getWorkingHistory = txt_WorkingHistory.getText();
        //byte[] getImage = supplierImage;

        Supplier_Models objSupplier_Models = new Supplier_Models(getSupplierNIC, getName, getBusinessName, getTelephoneNo, getEmail, sqldate, getWorkingHistory, getIntRating);
        Supplier_DB objSupplier_DB = new Supplier_DB();

        int x = objSupplier_DB.updateSupplier(objSupplier_Models);

        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Successfully updaeted");

        } else {
            JOptionPane.showMessageDialog(null, "Not updated");
        }
        loadSupplierTable();
    }//GEN-LAST:event_btn_UpdateSupplierActionPerformed

    private void btn_DeleteFromSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteFromSupplierActionPerformed
        String getEmployeeID = txt_SupplierNIC.getText();

        Supplier_Models objSupplier_Models = new Supplier_Models();
        objSupplier_Models.setSupplierNIC(getEmployeeID);
        Supplier_DB objSupplier_DB = new Supplier_DB();

        int x = objSupplier_DB.deleteSupplier(objSupplier_Models);
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Successfully Deleted");

        } else {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        }
        loadSupplierTable();
    }//GEN-LAST:event_btn_DeleteFromSupplierActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_BusinessName.setText("");
        txt_Email.setText("");
        txt_SupplierNIC.setText("");
        txt_Name.setText("");
        txt_WorkingHistory.setText("");
        txt_TelephoneNo.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_OpenCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OpenCameraActionPerformed

        WebCamera objWebCamera = new WebCamera();
        objWebCamera.setVisible(true);
    }//GEN-LAST:event_btn_OpenCameraActionPerformed

    private void btn_SendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendEmailActionPerformed

        String getEmailAddress = txt_Email.getText();

        new EmailPortal(getEmailAddress).setVisible(true);
    }//GEN-LAST:event_btn_SendEmailActionPerformed

    private void btn_BrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrowseImageActionPerformed

        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
        filechooser.addChoosableFileFilter(filter);
        int result = filechooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_SupplierImage.setIcon(ResizeImage(path));
            s = path;

            try {
                File image = new File(s);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[2000000];//Image size in bytes
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                supplierImage = bos.toByteArray();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Your Image is too large");
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No Data");
        }
    }//GEN-LAST:event_btn_BrowseImageActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        int value = jSlider1.getValue();

        if (value == 1) {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating1.png");
            lbl_sliderRating.setIcon(image);

        } else if (value == 2) {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating2.png");
            lbl_sliderRating.setIcon(image);

        } else if (value == 3) {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating3.png");
            lbl_sliderRating.setIcon(image);

        } else if (value == 4) {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating4.png");
            lbl_sliderRating.setIcon(image);

        } else {

            ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\Rating5.png");
            lbl_sliderRating.setIcon(image);

        }


    }//GEN-LAST:event_jSlider1StateChanged

    private void btn_UpdateImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateImageActionPerformed
        byte[] getImage = supplierImage;
        String supplierID = txt_SupplierNIC.getText();

        Supplier_Models objSupplier_Models = new Supplier_Models();
        objSupplier_Models.setImage(getImage);
        objSupplier_Models.setSupplierNIC(supplierID);

        Supplier_DB objSupplier_DB = new Supplier_DB();
        int x = objSupplier_DB.updateImage(objSupplier_Models);

        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Successfully updated");

        } else {
            JOptionPane.showMessageDialog(null, "Not updated");
        }
        loadSupplierTable();

    }//GEN-LAST:event_btn_UpdateImageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
            java.util.logging.Logger.getLogger(Supplier_Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier_Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier_Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier_Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier_Views().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddToSupplier;
    private javax.swing.JButton btn_BrowseImage;
    private javax.swing.JButton btn_DeleteFromSupplier;
    private javax.swing.JButton btn_OpenCamera;
    private javax.swing.JButton btn_SendEmail;
    private javax.swing.JButton btn_UpdateImage;
    private javax.swing.JButton btn_UpdateSupplier;
    private javax.swing.JButton btn_clear;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbl_Rating;
    private javax.swing.JLabel lbl_SupplierImage;
    private javax.swing.JLabel lbl_sliderRating;
    private javax.swing.JRadioButton rb_BusinessName;
    private javax.swing.JRadioButton rb_SupplierNIC;
    private javax.swing.JRadioButton rb_SupplierName;
    private javax.swing.JTable tbl_Supplier;
    private javax.swing.JTextField txt_BusinessName;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_SupplierNIC;
    private javax.swing.JTextField txt_TelephoneNo;
    private javax.swing.JTextArea txt_WorkingHistory;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
