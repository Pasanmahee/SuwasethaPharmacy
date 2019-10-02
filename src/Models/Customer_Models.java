/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author PASANMAHEE 2018.12.19
 */
// Class Declaration 
public class Customer_Models {
    
// Instance Variables 
    private String customerID;
    private String name;
    private String address;
    private String telephoneNo;
    private String email;
    private int loyaltyCardFees;
    private String medicalHistory;
    private String customerDetails;
    private byte[] image;
    private int age;
    
    // Constructor Declaration of Class 
     public Customer_Models(String getCustomerID, String getname, String getaddress, String gettelephoneNO, String getemail,
            int getage, int getLoyaltyCardFees, String getMedicalHistory) {

        this.address = getaddress;
        this.customerID = getCustomerID;
        this.age = getage;
        this.email = getemail;
        this.name = getname;
        this.loyaltyCardFees = getLoyaltyCardFees;
        this.medicalHistory = getMedicalHistory;
        this.telephoneNo = gettelephoneNO;

    }

    public Customer_Models() {

    }

    // method 1 
    public void setImage(byte[] getImage) {
        this.image = getImage;
    }

    public void setCustomerID(String getCustomerId) {
        this.customerID = getCustomerId;
    }

    public void setCustomerDetails(String getCustomerDetails) {

        this.customerDetails = getCustomerDetails;
    }

    public void setCustomerName(String getCustomername) {
        this.name = getCustomername;
    }

    public void setLoyaltyCardFees(int getLoyaltyCardfees) {

        this.loyaltyCardFees = getLoyaltyCardfees;

    }

    public void setAddress(String getAddress) {
        this.address = getAddress;
    }

    public void setAge(int getAge) {
        this.age = getAge;
    }

    public String getCustomerDetails() {
        return this.customerDetails;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public byte[] getImage() {
        return this.image;
    }

    public String getCustomerName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;

    }

    public int getAge() {
        return this.age;
    }

    public String getTelephoneNo() {
        return this.telephoneNo;
    }

    public String getMedicalHistory() {
        return this.medicalHistory;
    }

    public int getLoyaltyCardFees() {
        return this.loyaltyCardFees;
    }

   

}
