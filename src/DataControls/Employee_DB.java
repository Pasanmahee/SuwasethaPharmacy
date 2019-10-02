/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControls;

/**
 *
 * @author PASANMAHEE 2018.12.21
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Models.Employee_Models;
import suwasetha_pharmacy.DataBaseConnection;

public class Employee_DB {

    PreparedStatement pst;
    ResultSet rs;
    Connection conn;

    public Employee_DB() {
        conn = DataBaseConnection.getconnection();
    }

    public int insertEmployee(Employee_Models objEmployee_Models) {
        try {

            String sql = "insert into employee (Employee_ID,Employee_name,Address,Telephone_No,Email,Age,Join_Date,Qualifications,Image)values('" + objEmployee_Models.getEmployeeID() + "','" + objEmployee_Models.getEmployeeName() + "','" + objEmployee_Models.getAddress() + "','" + objEmployee_Models.getTelephoneNo() + "','" + objEmployee_Models.getEmail() + "'," + objEmployee_Models.getAge() + ",'" + objEmployee_Models.getJoinDate() + "','" + objEmployee_Models.getQualification() + "', ? )";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objEmployee_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Duplicate Employee ID");
        }
        return 0;

    }

    public int updateEmployee(Employee_Models objEmployee_Models) {
        try {
            String sql = "update employee set  Employee_Name='" + objEmployee_Models.getEmployeeName() + "',Address='" + objEmployee_Models.getAddress() + "',Telephone_No='" + objEmployee_Models.getTelephoneNo() + "',Email='" + objEmployee_Models.getEmail() + "',Age='" + objEmployee_Models.getAge() + "',Join_Date='" + objEmployee_Models.getJoinDate() + "',Qualifications='" + objEmployee_Models.getQualification() + "' where Employee_ID='" + objEmployee_Models.getEmployeeID() + "'";
            pst = conn.prepareStatement(sql);
            //pst.setBytes(1, objEmployee_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }

    public int updateImage(Employee_Models objEmployee_Models) {
        try {
            String sql = "update employee set  Image = ? " + " where Employee_ID='" + objEmployee_Models.getEmployeeID() + "'";
            pst = conn.prepareStatement(sql);
            pst.setBytes(1, objEmployee_Models.getImage());
            int x = pst.executeUpdate();
            return x;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return 0;

    }

    public int deleteEmployee(Employee_Models objEmployee_Models) {
        try {
            String sql = "delete from employee where Employee_ID='" + objEmployee_Models.getEmployeeID() + "'";
            pst = conn.prepareStatement(sql);
            int x = pst.executeUpdate();
            return x;

        } catch (Exception e) {
        }

        return 0;

    }

    public ResultSet loadEmployeeTable(Employee_Models objEmployee_Models) {
        try {
            String sql = "select Employee_ID,Employee_name,Address,Telephone_No,Email,Age,Join_Date,Qualifications from " + objEmployee_Models.getEmployeeDetails() + "";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }
        return null;

    }

    public ResultSet loadEmployeeTableID(Employee_Models objEmployee_Models) {
        try {
            String sql = "select * from employee where Employee_ID='" + objEmployee_Models.getEmployeeID() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
        }

        return null;
    }

    public ResultSet getSearchDetails(Employee_Models objEmployee_Models) {
        String sql = null;
        String employeeID = objEmployee_Models.getEmployeeID();
        String employeeName = objEmployee_Models.getEmployeeName();
        String address = objEmployee_Models.getAddress();
        int age = objEmployee_Models.getAge();
        if (employeeID != null) {
            sql = "select * from employee where Employee_ID like '%" + employeeID + "%' ";
        } else if (employeeName != null) {
            sql = "select * from employee where Employee_Name  like '%" + employeeName + "%'";

        } else if (address != null) {
            sql = "select * from employee where Address  like '%" + address + "%'";

        } else {
            sql = "select * from employee where Age  like '%" + age + "%'";

        }

        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public ResultSet loadImage(Employee_Models objEmployee_Models) {
        try {
            String sql = "select Image from employee where Employee_ID='" + objEmployee_Models.getEmployeeID() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return null;

    }

}
