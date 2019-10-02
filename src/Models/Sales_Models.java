/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author P
 */
public class Sales_Models {

    private String saleID;
    private String date;
    private String salesDetails;
    private String columnDetails;
    private double finaleAmount;

    public Sales_Models(String getSaleID, double getFinaleAmount, String getDate) {
        this.saleID = getSaleID;
        this.finaleAmount = getFinaleAmount;
        this.date = getDate;

    }

    public Sales_Models() {
    }

    public void setFinaleAmount(double getFinaleAmount) {
        this.finaleAmount = getFinaleAmount;

    }

    public void setSalesDetails(String getSalesDetails) {
        this.salesDetails = getSalesDetails;

    }

    public void setColumnDetails(String getColumnDetails) {

        this.columnDetails = getColumnDetails;

    }

    public void setSaleID(String getSaleID) {
        this.saleID = getSaleID;
    }

    public String getSalesDetails() {

        return this.salesDetails;
    }

    public String getColumnDetails() {
        return this.columnDetails;

    }

    public String getSaleID() {

        return this.saleID;

    }

    public double getFinaleAmount() {

        return this.finaleAmount;
    }

    public String getDate() {

        return this.date;
    }

}
