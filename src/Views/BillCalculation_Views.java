/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Models.DrugCategories_Models;
import DataControls.DrugCategories_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import Models.AddToCart_Models;
import DataControls.AddToCart_DB;
import Models.Customer_Models;
import DataControls.Customer_DB;
import javax.swing.ImageIcon;
import Models.Sales_Models;
import DataControls.Sales_DB;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
import suwasetha_pharmacy.DataBaseConnection;

/**
 *
 * @author PASANMAHEE 2018.12.26
 */
public class BillCalculation_Views extends javax.swing.JFrame {

    /**
     * Creates new form BillCalculation_Views
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public String columnname;
    public String tableName;
    public String getDrugName;
    public String getCartID;
    public String getQuantity;
    public int getRemainInStock;
    public int lastAddToCartID;
    public double finaleAmount = 0;
    public double discountAmount;
    public int loyaltyCardFees;
    public String lastSaleID;

    public BillCalculation_Views() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        conn = DataBaseConnection.getconnection();

        loadDrugCategoriesTable();
        firstR();
        loadAddToCartTable();
        loadSalesTable();

        /*Action addToCartAction = new AbstractAction("Add To Cart") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        };

        String key = "Add";

        btn_AddToCart.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7), key);*/
    }

    private void loadDrugCategoriesTable() {
        tableName = "drug_categories";
        DrugCategories_Models objDrugCategories_Models = new DrugCategories_Models();
        objDrugCategories_Models.setDrugCategoryDetails(tableName);
        DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();
        ResultSet rs = objDrugCategories_DB.loadDrugCategoryTableforBillCal(objDrugCategories_Models);

        try {
            if (rs.next()) {
                tbl_DrugCategories.setModel(DbUtils.resultSetToTableModel(rs));

            } else {
                JOptionPane.showMessageDialog(null, "No Drug Categories Table Found");
            }

        } catch (Exception e) {
        }

    }

    private void loadSalesTable() {
        tableName = "sales";
        Sales_Models objSales_Models = new Sales_Models();
        objSales_Models.setSalesDetails(tableName);
        Sales_DB objSales_DB = new Sales_DB();
        ResultSet rs = objSales_DB.loadSalesTable(objSales_Models);

        try {
            if (rs.next()) {
                tbl_SalesTable.setModel(DbUtils.resultSetToTableModel(rs));

            } else {
                JOptionPane.showMessageDialog(null, "No Sales Table Found");
            }

        } catch (Exception e) {
        }

    }

    private void firstR() {

        int CartID = 0;
        String getDrugName = "Null";
        String getBrandName = "Null";
        double intSellingPrice = 0.0;
        int intnQuantity = 0;

        AddToCart_Models objAddToCart_Models = new AddToCart_Models(CartID, getDrugName, getBrandName, intSellingPrice, intnQuantity);
        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        objAddToCart_DB.insertAddToCart(objAddToCart_Models);

    }

    private void clear() {

        txt_BrandName.setText("");
        txt_CustomerID.setText("");
        txt_DiscountPercentage.setText("");
        txt_DrugName.setText("");
        txt_FinaleAmount.setText("");
        txt_LoyaltyCardDiscount.setText("");
        txt_Quantity.setText("");
        txt_RemainInStock.setText("");
        txt_SubTotal.setText("");
        txt_profit.setText("");
        txt_sellingPrice.setText("");
        txt_valueAfterDiscount.setText("");
        txt_Balance.setText("");
        txt_Cash.setText("");

    }

    private void deleteAllFromAddToCart() {
        tableName = "add_to_cart";
        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setColumnDetails(tableName);

        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        objAddToCart_DB.deleteAll(objAddToCart_Models);

    }

    private void reduceRemainInStock() {
        try {
            String strRemainInStock = txt_RemainInStock.getText();
            String getDrugName = txt_DrugName.getText();
            String strQuantity = txt_Quantity.getText();
            int intRemainInStock = Integer.parseInt(strRemainInStock);
            int intQuantity = Integer.parseInt(strQuantity);
            if (intRemainInStock < intQuantity) {

            } else {
                int newRemainInStock = intRemainInStock - intQuantity;

                DrugCategories_Models objCategories_Models = new DrugCategories_Models();
                objCategories_Models.setRemainInStock(newRemainInStock);
                objCategories_Models.setDrugName(getDrugName);
                DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();

                objDrugCategories_DB.updateRemainInStock(objCategories_Models);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please add a Quantity");
        }
    }

    private void getRemainInstock() {

        DrugCategories_Models objCategories_Models = new DrugCategories_Models();
        objCategories_Models.setDrugName(getDrugName);
        DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();

        ResultSet rs = objDrugCategories_DB.getRemainInStock(objCategories_Models);
        try {
            if (rs.next()) {
                getRemainInStock = rs.getInt("Remain_in_stock");
                /* String ss = String.valueOf(getRemainInStock);
                txt_LoyaltyCardDiscount.setText(ss);*/
            }
        } catch (Exception e) {
        }

    }

    private void addToremainInStock() {
        int getIntQuantity = Integer.parseInt(getQuantity);
        int newRemainInStock = getRemainInStock + getIntQuantity;
        DrugCategories_Models objCategories_Models = new DrugCategories_Models();
        objCategories_Models.setDrugName(getDrugName);
        objCategories_Models.setRemainInStock(newRemainInStock);
        DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();
        objDrugCategories_DB.updateRemainInStock(objCategories_Models);

    }

    private void getSum() {
        columnname = "Selling_price";
        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setColumnDetails(columnname);
        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        ResultSet rs = objAddToCart_DB.getSum(objAddToCart_Models);
        try {
            if (rs.next()) {
                double doubleSum = rs.getDouble(1);
                String strSum = String.valueOf(doubleSum);
                txt_SubTotal.setText(strSum);

            } else {
                JOptionPane.showMessageDialog(null, "No Add To Cart Table Found");
            }

        } catch (Exception e) {
        }
    }

    private void calculateDiscount() {
        String getSubTotal = txt_SubTotal.getText();
        double doubleSubTotal = Double.parseDouble(getSubTotal);

        if (doubleSubTotal > 1000.0) {

            txt_DiscountPercentage.setText("6%");
            discountAmount = doubleSubTotal * 6 / 100;
            finaleAmount = doubleSubTotal - discountAmount;

            String strFinaleAmount = String.valueOf(finaleAmount);
            txt_valueAfterDiscount.setText(strFinaleAmount);
        } else if (doubleSubTotal > 500.0) {

            txt_DiscountPercentage.setText("4%");
            discountAmount = doubleSubTotal * 4 / 100;
            finaleAmount = doubleSubTotal - discountAmount;

            String strFinaleAmount = String.valueOf(finaleAmount);
            txt_valueAfterDiscount.setText(strFinaleAmount);

        } else {

            txt_DiscountPercentage.setText("No discount");

            txt_valueAfterDiscount.setText(getSubTotal);
        }

    }

    private void loadAddToCartTable() {
        tableName = "add_to_cart";
        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setAddToCartDetails(tableName);
        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        ResultSet rs = objAddToCart_DB.loadAddToCartTable(objAddToCart_Models);

        try {
            while (rs.next()) {

                tbl_AddToCart.setModel(DbUtils.resultSetToTableModel(rs));

            }

        } catch (Exception e) {
        }

    }

    private void getLasstAddToCartID() {
        columnname = "Cart_ID";

        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setColumnDetails(columnname);

        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        ResultSet rs = objAddToCart_DB.getLastAddToCartID(objAddToCart_Models);
        try {
            if (rs.next()) {

                lastAddToCartID = rs.getInt("Cart_ID");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void getLastSaleID() {

        columnname = "Sales_ID";

        Sales_Models objSales_Models = new Sales_Models();
        objSales_Models.setColumnDetails(columnname);

        Sales_DB objSales_DB = new Sales_DB();
        ResultSet rs = objSales_DB.getLastSaleID(objSales_Models);
        try {
            if (rs.next()) {

                lastSaleID = rs.getString("Sales_ID");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void addDicntAmntandFinaleAmntToAddToCartTable() {
        getLasstAddToCartID();
        int newAddToCartID = lastAddToCartID + 1;

        String finaleAmount = txt_FinaleAmount.getText();
        double doubleFinaleAmount = Double.parseDouble(finaleAmount);

        String subTotal = txt_SubTotal.getText();
        double doubleSubTotal = Double.parseDouble(subTotal);

        double discountAmount = doubleSubTotal - doubleFinaleAmount;

        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setCartID(newAddToCartID);
        objAddToCart_Models.setFinaleAmount(doubleFinaleAmount);
        objAddToCart_Models.setDiscountAmount(discountAmount);

        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        objAddToCart_DB.insertAddToCartDiscountandFinaleAmount(objAddToCart_Models);

        loadAddToCartTable();

    }

    private void getBalance() {

        String cash = txt_Cash.getText();
        String finaleAmount = txt_FinaleAmount.getText();

        double doublecash = Double.parseDouble(cash);
        double doubleFinaleAmount = Double.parseDouble(finaleAmount);

        double balance = doublecash - doubleFinaleAmount;

        String strBalance = String.valueOf(balance);
        txt_Balance.setText(strBalance);

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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_DrugName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_BrandName = new javax.swing.JTextField();
        txt_sellingPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_RemainInStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_profit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_AddToCart = new javax.swing.JButton();
        txt_SubTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_loyaltyCard = new javax.swing.JLabel();
        txt_LoyaltyCardDiscount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_DiscountPercentage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_FinaleAmount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_AddToSales = new javax.swing.JButton();
        btn_Clear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btn_RemoveFromCart = new javax.swing.JButton();
        btn_Total = new javax.swing.JButton();
        btn_Print = new javax.swing.JButton();
        txt_CustomerID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_valueAfterDiscount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btn_OpenCustomer = new javax.swing.JButton();
        txt_Cash = new javax.swing.JTextField();
        txt_Balance = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rb_Category = new javax.swing.JRadioButton();
        rb_DrugName = new javax.swing.JRadioButton();
        rb_BrandName = new javax.swing.JRadioButton();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DrugCategories = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer,int row,int column ){

                Component c = super.prepareRenderer(renderer, row, column);
                c.setBackground(Color.DARK_GRAY);
                Object stockValue = getModel().getValueAt(row,4);
                Object reOderValue = getModel().getValueAt(row,5);
                int intStockValue = (Integer) stockValue;
                int intReorderValue = (Integer)  reOderValue;

                if(intStockValue < intReorderValue){
                    c.setBackground(Color.RED);
                }
                else if(intStockValue > intReorderValue){
                    c.setBackground(Color.GREEN);
                }
                else{ c.setBackground(Color.DARK_GRAY);
                }

                return c;
            }

        };
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_AddToCart = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_SalesTable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Pharmacy.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Drug Name");

        txt_DrugName.setEditable(false);
        txt_DrugName.setBackground(new java.awt.Color(51, 51, 51));
        txt_DrugName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_DrugName.setForeground(new java.awt.Color(255, 255, 255));
        txt_DrugName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Brand Name");

        txt_BrandName.setEditable(false);
        txt_BrandName.setBackground(new java.awt.Color(51, 51, 51));
        txt_BrandName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_BrandName.setForeground(new java.awt.Color(255, 255, 255));
        txt_BrandName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_sellingPrice.setEditable(false);
        txt_sellingPrice.setBackground(new java.awt.Color(51, 51, 51));
        txt_sellingPrice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_sellingPrice.setForeground(new java.awt.Color(255, 255, 255));
        txt_sellingPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_sellingPrice.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selling Price");

        txt_RemainInStock.setEditable(false);
        txt_RemainInStock.setBackground(new java.awt.Color(51, 51, 51));
        txt_RemainInStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_RemainInStock.setForeground(new java.awt.Color(255, 255, 255));
        txt_RemainInStock.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Remain In Stock");

        txt_profit.setEditable(false);
        txt_profit.setBackground(new java.awt.Color(51, 51, 51));
        txt_profit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_profit.setForeground(new java.awt.Color(255, 255, 255));
        txt_profit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_profit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profit From One Item");

        btn_AddToCart.setBackground(new java.awt.Color(153, 153, 153));
        btn_AddToCart.setForeground(new java.awt.Color(0, 0, 0));
        btn_AddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/AddToCart.png"))); // NOI18N
        btn_AddToCart.setText("Add to cart");
        btn_AddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddToCartActionPerformed(evt);
            }
        });

        txt_SubTotal.setEditable(false);
        txt_SubTotal.setBackground(new java.awt.Color(51, 51, 51));
        txt_SubTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_SubTotal.setForeground(new java.awt.Color(255, 255, 255));
        txt_SubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_SubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sub Total");

        txt_Quantity.setBackground(new java.awt.Color(102, 102, 102));
        txt_Quantity.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Quantity.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Customer ID");

        lbl_loyaltyCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/LoyaltyCardno.png"))); // NOI18N

        txt_LoyaltyCardDiscount.setBackground(new java.awt.Color(102, 102, 102));
        txt_LoyaltyCardDiscount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_LoyaltyCardDiscount.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Loyalty Card Discount");

        txt_DiscountPercentage.setEditable(false);
        txt_DiscountPercentage.setBackground(new java.awt.Color(51, 51, 51));
        txt_DiscountPercentage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_DiscountPercentage.setForeground(new java.awt.Color(255, 255, 255));
        txt_DiscountPercentage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Discount ");

        txt_FinaleAmount.setEditable(false);
        txt_FinaleAmount.setBackground(new java.awt.Color(51, 51, 51));
        txt_FinaleAmount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_FinaleAmount.setForeground(new java.awt.Color(255, 255, 255));
        txt_FinaleAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_FinaleAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Final Amount");

        btn_AddToSales.setBackground(new java.awt.Color(153, 153, 153));
        btn_AddToSales.setForeground(new java.awt.Color(0, 0, 0));
        btn_AddToSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Add.png"))); // NOI18N
        btn_AddToSales.setText("ADD");
        btn_AddToSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddToSalesActionPerformed(evt);
            }
        });

        btn_Clear.setBackground(new java.awt.Color(153, 153, 153));
        btn_Clear.setForeground(new java.awt.Color(0, 0, 0));
        btn_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Clear.png"))); // NOI18N
        btn_Clear.setText("CLEAR");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("BILL CALCULATION PORTAL");

        btn_RemoveFromCart.setBackground(new java.awt.Color(153, 153, 153));
        btn_RemoveFromCart.setForeground(new java.awt.Color(0, 0, 0));
        btn_RemoveFromCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/RemoveFromCart.png"))); // NOI18N
        btn_RemoveFromCart.setText("Remove ");
        btn_RemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveFromCartActionPerformed(evt);
            }
        });

        btn_Total.setBackground(new java.awt.Color(153, 153, 153));
        btn_Total.setForeground(new java.awt.Color(0, 0, 0));
        btn_Total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Total.png"))); // NOI18N
        btn_Total.setText("TOTAL");
        btn_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TotalActionPerformed(evt);
            }
        });

        btn_Print.setBackground(new java.awt.Color(153, 153, 153));
        btn_Print.setForeground(new java.awt.Color(0, 0, 0));
        btn_Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Print.png"))); // NOI18N
        btn_Print.setText("PRINT");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });

        txt_CustomerID.setBackground(new java.awt.Color(102, 102, 102));
        txt_CustomerID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_CustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CustomerIDActionPerformed(evt);
            }
        });
        txt_CustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CustomerIDKeyReleased(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rs.");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Rs.");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Rs.");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Rs.");

        txt_valueAfterDiscount.setEditable(false);
        txt_valueAfterDiscount.setBackground(new java.awt.Color(51, 51, 51));
        txt_valueAfterDiscount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_valueAfterDiscount.setForeground(new java.awt.Color(255, 255, 255));
        txt_valueAfterDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_valueAfterDiscount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Rs.");

        jDateChooser1.setBackground(new java.awt.Color(102, 102, 102));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));

        btn_OpenCustomer.setBackground(new java.awt.Color(153, 153, 153));
        btn_OpenCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Customer24x24.png"))); // NOI18N
        btn_OpenCustomer.setText("Open Customer");
        btn_OpenCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OpenCustomerActionPerformed(evt);
            }
        });

        txt_Cash.setBackground(new java.awt.Color(102, 102, 102));
        txt_Cash.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Cash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_Cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CashKeyReleased(evt);
            }
        });

        txt_Balance.setBackground(new java.awt.Color(51, 51, 51));
        txt_Balance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Balance.setForeground(new java.awt.Color(255, 0, 0));
        txt_Balance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_Balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Rs.");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Rs.");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cash");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Balance");

        jLabel28.setText("%");

        jLabel29.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel24))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_valueAfterDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(txt_SubTotal))
                                        .addContainerGap())))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_DrugName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_BrandName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_RemainInStock, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Quantity, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_LoyaltyCardDiscount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(txt_CustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(txt_DiscountPercentage))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29))
                                        .addGap(0, 293, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lbl_loyaltyCard, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel26))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel23)
                                                    .addComponent(jLabel25))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_FinaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_OpenCustomer)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btn_RemoveFromCart, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_AddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_AddToSales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel13)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_DrugName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_BrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_RemainInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_RemoveFromCart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DiscountPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_valueAfterDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_OpenCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_LoyaltyCardDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel29))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_FinaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel13)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_loyaltyCard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Clear)
                    .addComponent(btn_AddToSales)
                    .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        buttonGroup1.add(rb_Category);
        rb_Category.setForeground(new java.awt.Color(255, 255, 255));
        rb_Category.setText("Category");

        buttonGroup1.add(rb_DrugName);
        rb_DrugName.setForeground(new java.awt.Color(255, 255, 255));
        rb_DrugName.setText("Drug Name");

        buttonGroup1.add(rb_BrandName);
        rb_BrandName.setForeground(new java.awt.Color(255, 255, 255));
        rb_BrandName.setText("Brand Name");

        txt_search.setBackground(new java.awt.Color(0, 153, 153));
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        tbl_DrugCategories.setBackground(new java.awt.Color(153, 153, 153));
        tbl_DrugCategories.setForeground(new java.awt.Color(0, 0, 0));
        tbl_DrugCategories.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_DrugCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DrugCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DrugCategories);

        tbl_AddToCart.setBackground(new java.awt.Color(153, 153, 153));
        tbl_AddToCart.setForeground(new java.awt.Color(255, 255, 255));
        tbl_AddToCart.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_AddToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_AddToCartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_AddToCart);

        tbl_SalesTable.setBackground(new java.awt.Color(153, 153, 153));
        tbl_SalesTable.setForeground(new java.awt.Color(255, 255, 255));
        tbl_SalesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_SalesTable);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/icons8_Search_31px.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/DrugCategories.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Cart.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/suwasetha_pharmacy/Sales.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rb_Category)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_DrugName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_BrandName))
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addGap(48, 48, 48))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_Category)
                            .addComponent(rb_DrugName)
                            .addComponent(rb_BrandName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(65, 65, 65))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        DrugCategories_Models objCategories_Models = new DrugCategories_Models();
        String value = txt_search.getText();
        DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();

        if (rb_Category.isSelected()) {

            objCategories_Models.setCategory(value);
        } else if (rb_DrugName.isSelected()) {

            objCategories_Models.setDrugName(value);
        } else if (rb_BrandName.isSelected()) {

            objCategories_Models.setBrandName(value);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Button before you search");
        }
        ResultSet rs = objDrugCategories_DB.getSearchDetails(objCategories_Models);

        tbl_DrugCategories.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_txt_searchKeyReleased

    private void tbl_DrugCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DrugCategoriesMouseClicked
        int row = tbl_DrugCategories.getSelectedRow();
        String tableClick = tbl_DrugCategories.getModel().getValueAt(row, 1).toString();

        DrugCategories_Models objCategories_Models = new DrugCategories_Models();
        objCategories_Models.setDrugName(tableClick);
        DrugCategories_DB objDrugCategories_DB = new DrugCategories_DB();

        ResultSet rs = objDrugCategories_DB.loadDrugCategoryID(objCategories_Models);
        try {
            if (rs.next()) {

                txt_DrugName.setText(rs.getString("Drug_name"));

                txt_BrandName.setText(rs.getString("Brand_name"));
                txt_RemainInStock.setText(rs.getString("Remain_in_stock"));
                double getDoubleBuyingPrice = rs.getDouble("Buying_price");
                double getDoubleSellingPrice = rs.getDouble("Selling_price");
                double doubleProfit = getDoubleSellingPrice - getDoubleBuyingPrice;

                String strSellingPrice = String.valueOf(getDoubleSellingPrice);
                String strProfit = String.valueOf(doubleProfit);

                txt_sellingPrice.setText(strSellingPrice);
                txt_profit.setText(strProfit);

            } else {
                //JOptionPane.showMessageDialog(null, "Error");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbl_DrugCategoriesMouseClicked


    private void btn_AddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddToCartActionPerformed
        String strRemainInStock = txt_RemainInStock.getText();

        String strQuantity = txt_Quantity.getText();
        int intRemainInStock = Integer.parseInt(strRemainInStock);
        int intQuantity = Integer.parseInt(strQuantity);
        if (intRemainInStock < intQuantity) {
            JOptionPane.showMessageDialog(null, "Not enough products in stock");
        } else {
            getLasstAddToCartID();

            int newAddToCartID = lastAddToCartID + 1;
            String getDrugName = txt_DrugName.getText();
            String getBrandName = txt_BrandName.getText();
            String getStrSellingPrice = txt_sellingPrice.getText();
            String getStrQuantity = txt_Quantity.getText();

            double doubleSellingPrice = Double.parseDouble(getStrSellingPrice);
            int intnQuantity = Integer.parseInt(getStrQuantity);
            double nSellingPrice = doubleSellingPrice * intQuantity;

            AddToCart_Models objAddToCart_Models = new AddToCart_Models(newAddToCartID, getDrugName, getBrandName, nSellingPrice, intnQuantity);
            AddToCart_DB objAddToCart_DB = new AddToCart_DB();
            int x = objAddToCart_DB.insertAddToCart(objAddToCart_Models);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Added to cart");

            } else {
                JOptionPane.showMessageDialog(null, "Not added");
            }

            reduceRemainInStock();
            loadDrugCategoriesTable();
            loadAddToCartTable();
        }
        getSum();
        calculateDiscount();

    }//GEN-LAST:event_btn_AddToCartActionPerformed

    private void tbl_AddToCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AddToCartMouseClicked
        int row = tbl_AddToCart.getSelectedRow();
        getCartID = tbl_AddToCart.getModel().getValueAt(row, 0).toString();
        getDrugName = tbl_AddToCart.getModel().getValueAt(row, 1).toString();
        getQuantity = tbl_AddToCart.getModel().getValueAt(row, 4).toString();


    }//GEN-LAST:event_tbl_AddToCartMouseClicked

    private void btn_RemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveFromCartActionPerformed

        getRemainInstock();
        addToremainInStock();
        loadDrugCategoriesTable();

        int getIntCartID = Integer.parseInt(getCartID);
        AddToCart_Models objAddToCart_Models = new AddToCart_Models();
        objAddToCart_Models.setCartID(getIntCartID);

        AddToCart_DB objAddToCart_DB = new AddToCart_DB();
        int x = objAddToCart_DB.deleteAddToCart(objAddToCart_Models);
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Removed from cart");

        } else {
            JOptionPane.showMessageDialog(null, "Not removed");
        }
        loadAddToCartTable();
        getSum();
        calculateDiscount();


    }//GEN-LAST:event_btn_RemoveFromCartActionPerformed

    private void txt_CustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CustomerIDActionPerformed

    }//GEN-LAST:event_txt_CustomerIDActionPerformed

    private void txt_CustomerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CustomerIDKeyReleased
        String getCustomerID = txt_CustomerID.getText();
        Customer_Models objCustomer_Models = new Customer_Models();
        objCustomer_Models.setCustomerID(getCustomerID);

        Customer_DB objCustomer_DB = new Customer_DB();
        ResultSet rs = objCustomer_DB.getLoyaltyCardFees(objCustomer_Models);

        try {

            if (rs.next()) {

                loyaltyCardFees = rs.getInt(1);

                if (loyaltyCardFees >= 200) {
                    ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\LoyaltyCardyes.png");
                    lbl_loyaltyCard.setIcon(image);

                }
            } else {
                ImageIcon image = new ImageIcon("E:\\HNDJava\\Suwasetha_Pharmacy\\src\\suwasetha_pharmacy\\LoyaltyCardno.png");
                lbl_loyaltyCard.setIcon(image);

            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_txt_CustomerIDKeyReleased

    private void btn_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TotalActionPerformed
        try {
            String getCustomerID = txt_CustomerID.getText();

            Customer_Models objCustomer_Models = new Customer_Models();
            objCustomer_Models.setCustomerID(getCustomerID);

            Customer_DB objCustomer_DB = new Customer_DB();
            ResultSet rs = objCustomer_DB.getLoyaltyCardFees(objCustomer_Models);

            String strValueAfterDiscount = txt_valueAfterDiscount.getText();
            String strLoyaltyCardDiscountPercentage = txt_LoyaltyCardDiscount.getText();
            txt_FinaleAmount.setText(strValueAfterDiscount);

            double doubleValueAfterDiscount = Double.parseDouble(strValueAfterDiscount);
            int intLoyaltyCardDiscountPercentage = Integer.parseInt(strLoyaltyCardDiscountPercentage);

            if (rs.next()) {

                loyaltyCardFees = rs.getInt(1);

                if (loyaltyCardFees >= 200) {

                    double nTotal = doubleValueAfterDiscount * intLoyaltyCardDiscountPercentage / 100;
                    double Total = doubleValueAfterDiscount - nTotal;

                    String strTotal = String.valueOf(Total);
                    txt_FinaleAmount.setText(strTotal);

                } else if (loyaltyCardFees < 200) {

                    txt_FinaleAmount.setText(strValueAfterDiscount);

                }

            } else {

                txt_FinaleAmount.setText(strValueAfterDiscount);

            }

        } catch (Exception e) {
        }

        addDicntAmntandFinaleAmntToAddToCartTable();


    }//GEN-LAST:event_btn_TotalActionPerformed

    private void btn_AddToSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddToSalesActionPerformed

        getLastSaleID();
        int intlastSaleID = Integer.parseInt(lastSaleID);
        int newSalesID = intlastSaleID + 1;

        String strSalesID = String.valueOf(newSalesID);
        String strFinaleAmount = txt_FinaleAmount.getText();

        double doubleFinaleAmount = Double.parseDouble(strFinaleAmount);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);

        Sales_Models objModels = new Sales_Models(strSalesID, doubleFinaleAmount, currentTime);
        Sales_DB objSales_DB = new Sales_DB();
        int x = objSales_DB.insertSales(objModels);
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Sales Details added");

        } else {
            JOptionPane.showMessageDialog(null, "Not Added");
        }

        loadSalesTable();
        deleteAllFromAddToCart();
        firstR();
        loadAddToCartTable();
        clear();


    }//GEN-LAST:event_btn_AddToSalesActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        clear();
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_OpenCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OpenCustomerActionPerformed
        Customer_Views objCustomer_Views = new Customer_Views();
        objCustomer_Views.setVisible(true);
    }//GEN-LAST:event_btn_OpenCustomerActionPerformed

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed

        try {
            tableName = "add_to_cart";
            AddToCart_Models objAddToCart_Models = new AddToCart_Models();
            objAddToCart_Models.setAddToCartDetails(tableName);
            AddToCart_DB objAddToCart_DB = new AddToCart_DB();
            JasperDesign jd = objAddToCart_DB.billPrint(objAddToCart_Models);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btn_PrintActionPerformed

    private void txt_CashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CashKeyReleased
        getBalance();
    }//GEN-LAST:event_txt_CashKeyReleased

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
            java.util.logging.Logger.getLogger(BillCalculation_Views.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillCalculation_Views.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillCalculation_Views.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillCalculation_Views.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillCalculation_Views().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddToCart;
    private javax.swing.JButton btn_AddToSales;
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_OpenCustomer;
    private javax.swing.JButton btn_Print;
    private javax.swing.JButton btn_RemoveFromCart;
    private javax.swing.JButton btn_Total;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_loyaltyCard;
    private javax.swing.JRadioButton rb_BrandName;
    private javax.swing.JRadioButton rb_Category;
    private javax.swing.JRadioButton rb_DrugName;
    private javax.swing.JTable tbl_AddToCart;
    private javax.swing.JTable tbl_DrugCategories;
    private javax.swing.JTable tbl_SalesTable;
    private javax.swing.JTextField txt_Balance;
    private javax.swing.JTextField txt_BrandName;
    private javax.swing.JTextField txt_Cash;
    private javax.swing.JTextField txt_CustomerID;
    private javax.swing.JTextField txt_DiscountPercentage;
    private javax.swing.JTextField txt_DrugName;
    private javax.swing.JTextField txt_FinaleAmount;
    private javax.swing.JTextField txt_LoyaltyCardDiscount;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_RemainInStock;
    private javax.swing.JTextField txt_SubTotal;
    private javax.swing.JTextField txt_profit;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_sellingPrice;
    private javax.swing.JTextField txt_valueAfterDiscount;
    // End of variables declaration//GEN-END:variables
}
