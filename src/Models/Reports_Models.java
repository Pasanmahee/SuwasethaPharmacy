/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2019.1.4
 */
public class Reports_Models {

    private java.sql.Date fromDate;
    private java.sql.Date toDate;
    String total;

    public Reports_Models(java.sql.Date getFromDate, java.sql.Date getToDate) {

        this.fromDate = getFromDate;
        this.toDate = getToDate;

    }

    public Reports_Models() {
    }

    public void setFromDate(java.sql.Date getFromDate) {
        this.fromDate = getFromDate;

    }

    public void setToDate(java.sql.Date getToDate) {

        this.toDate = getToDate;

    }

    public void setTotal(String getTotal) {

        this.total = getTotal;

    }

    public String getTotal() {
        return this.total;

    }

    public java.sql.Date getFromDate() {
        return this.fromDate;

    }

    public java.sql.Date getToDate() {
        return this.toDate;

    }

}
