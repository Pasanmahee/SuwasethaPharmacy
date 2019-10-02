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
public class Employee_Models {

    private String employeeID;
    private String name;
    private String address;
    private String telephoneNo;
    private String email;
    private String qualification;
    private String employeeDetails;
    private java.sql.Date joinDate;
    private byte[] image;
    private int age;

    public Employee_Models(String getEmployeeID, String getname, String getaddress, String gettelephoneNO, String getemail,
            int getage, java.sql.Date getjoinDate, String getqualification) {

        this.address = getaddress;
        this.employeeID = getEmployeeID;
        this.age = getage;
        this.email = getemail;
        this.name = getname;
        this.joinDate = getjoinDate;
        this.qualification = getqualification;
        this.telephoneNo = gettelephoneNO;

    }

    public Employee_Models() {

    }

    public void setImage(byte[] getImage) {
        this.image = getImage;
    }

    public void setEmployeeID(String getEmployeeId) {
        this.employeeID = getEmployeeId;
    }

    public void setEmployeeDetails(String getEmployeeDetails) {

        this.employeeDetails = getEmployeeDetails;
    }

    public void setEmployeeName(String getEmployeeName) {
        this.name = getEmployeeName;
    }

    public void setAddress(String getAddress) {
        this.address = getAddress;
    }

    public void setAge(int getAge) {
        this.age = getAge;
    }

    public String getEmployeeDetails() {
        return this.employeeDetails;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public byte[] getImage() {
        return this.image;
    }

    public String getEmployeeName() {
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

    public String getQualification() {
        return this.qualification;
    }

    public java.sql.Date getJoinDate() {
        return this.joinDate;
    }

}
