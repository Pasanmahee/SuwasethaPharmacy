/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2018.12.21
 */
public class Supplier_Models {

    private String nic;
    private String name;
    private String businessName;
    private String telephoneNo;
    private String email;
    private String workingHistory;
    private String supplierDetails;
    private java.sql.Date joinDate;
    private byte[] image;
    private int rating;

    public Supplier_Models(String getNic, String getName, String getBusinessName, String getTelephoneNo, String getEmail, java.sql.Date getJoinDate,
            String getWorkingHistory, int getRating) {

        this.businessName = getBusinessName;
        this.email = getEmail;
        this.joinDate = getJoinDate;
        this.name = getName;
        this.nic = getNic;
        this.rating = getRating;
        this.telephoneNo = getTelephoneNo;
        this.workingHistory = getWorkingHistory;

    }

    public Supplier_Models() {

    }

    public void setImage(byte[] getImage) {
        this.image = getImage;
    }

    public void setSupplierNIC(String getSupplierNIC) {
        this.nic = getSupplierNIC;
    }

    public void setSupplierDetails(String getSupplierDetails) {

        this.supplierDetails = getSupplierDetails;
    }

    public void setSupplierName(String getSupplierName) {
        this.name = getSupplierName;
    }

    public void setBusinessName(String getBusinessName) {
        this.businessName = getBusinessName;
    }

    public void setRating(int getRating) {
        this.rating = getRating;
    }

    public String getSupplierDetails() {
        return this.supplierDetails;
    }

    public String getSupplierNIC() {

        return this.nic;

    }

    public byte[] getImage() {
        return this.image;
    }

    public String getSupplierName() {
        return this.name;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getEmail() {
        return this.email;

    }

    public int getRating() {
        return this.rating;
    }

    public String getTelephoneNo() {
        return this.telephoneNo;
    }

    public String getWorkingHistory() {
        return this.workingHistory;
    }

    public java.sql.Date getJoinDate() {
        return this.joinDate;
    }

}
