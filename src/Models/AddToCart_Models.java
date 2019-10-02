/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2018.12.27
 */
public class AddToCart_Models {

    private int cartID;
    private double sellingPrice;
    private int quantity;
    private double discountAmount;
    private double finaleAmount;
    private String addToCartDetails;
    private String columnDetails;
    private String drugName;
    private String brandName;

    public AddToCart_Models(int getCartID, String getDrugName, String getBrandName, double getSellingPrice, int getQuantity) {

        this.cartID = getCartID;
        this.brandName = getBrandName;
        this.drugName = getDrugName;
        this.quantity = getQuantity;
        this.sellingPrice = getSellingPrice;

    }

    public AddToCart_Models() {
    }

    public void setAddToCartDetails(String getAddToCartDetails) {
        this.addToCartDetails = getAddToCartDetails;

    }

    public void setColumnDetails(String getColumnDetails) {
        this.columnDetails = getColumnDetails;
    }

    public void setCartID(int getCartID) {
        this.cartID = getCartID;

    }

    public void setDiscountAmount(double getDiscountAmount) {

        this.discountAmount = getDiscountAmount;
    }

    public void setFinaleAmount(double getFinaleAmount) {

        this.finaleAmount = getFinaleAmount;

    }

    public void setQuantity(int getQuantity) {
        this.quantity = getQuantity;

    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getFinaleAmount() {
        return this.finaleAmount;
    }

    public String getAddToCartDetails() {
        return this.addToCartDetails;
    }

    public String getColumnDetails() {
        return this.columnDetails;
    }

    public int getCartID() {
        return this.cartID;

    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
