/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2018.12.24
 */
public class DrugCategories_Models {

    private String category;
    private String drugName;
    private String brandName;
    private String supplierNIC;
    private double buyingPrice;
    private double sellingPrice;
    private int remainInStock;
    private int reOderValue;
    private java.sql.Date expiryDate;
    private String sideEffects;
    private String drugCategoryDetails;

    public DrugCategories_Models(String getCategory, String getDrugName, String getBrandName, String getSupplierNIC,
            double getBuyingPrice, double getSellingPrice, int getRemainInStock, int getReOderValue, java.sql.Date getExpiryDate, String getSideEffects) {

        this.brandName = getBrandName;
        this.buyingPrice = getBuyingPrice;
        this.category = getCategory;
        this.drugName = getDrugName;
        this.expiryDate = getExpiryDate;
        this.remainInStock = getRemainInStock;
        this.sellingPrice = getSellingPrice;
        this.sideEffects = getSideEffects;
        this.supplierNIC = getSupplierNIC;
        this.reOderValue = getReOderValue;

    }

    public DrugCategories_Models() {

    }

    public void setDrugName(String getDrugName) {
        this.drugName = getDrugName;
    }

    public void setCategory(String getCategory) {
        this.category = getCategory;

    }

    public void setBrandName(String getBrandname) {
        this.brandName = getBrandname;
    }

    public void setDrugCategoryDetails(String getDrugCategoryDetails) {
        this.drugCategoryDetails = getDrugCategoryDetails;
    }

    public void setRemainInStock(int getRemainInStock) {

        this.remainInStock = getRemainInStock;

    }

    public void setReOrderValue(int getReOrderValue) {

        this.reOderValue = getReOrderValue;

    }

    public String getDrugCategoryDetails() {
        return this.drugCategoryDetails;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getSupplierNIC() {
        return this.supplierNIC;
    }

    public double getBuyingPrice() {
        return this.buyingPrice;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public int getRemainInStock() {
        return this.remainInStock;
    }

    public int getReorderValue() {
        return this.reOderValue;
    }

    public java.sql.Date getExpiryDate() {
        return this.expiryDate;
    }

    public String getSideEffects() {
        return this.sideEffects;
    }

}
