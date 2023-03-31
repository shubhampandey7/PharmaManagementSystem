/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author bhawana
 */
public class table {

    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            st.executeUpdate("create table appuser(appuser_pk int AUTO_INCREMENT primary key,userRole varchar(50),name varchar(50),dob varchar(50),mobileNumber varchar(50),email varchar(50),username varchar(50),password varchar(50),address varchar(200))");
            st.executeUpdate("insert into appuser(userRole,name,dob,mobileNumber,email,username,password,address)value('Admin','Admin','11-01-1997','9847112602','admin@gmail.com','admin','admin','Nepal')");
            JOptionPane.showMessageDialog(null,"Table created successufully with admin's details!!!");
            st.executeUpdate("create table medicine(medicine_pk int AUTO_INCREMENT primary key,uniqueId varchar(200),name varchar(200),companyName varchar(200),quantity bigint,price bigint,UNIQUE(uniqueId))");
            JOptionPane.showMessageDialog(null, "Medicine Table created successufully !!!");
            st.executeUpdate("create table bill(bill_pk int AUTO_INCREMENT primary key,billId varchar(200),billDate varchar(50),totalPaid bigint,generatedBy varchar(200))");
            JOptionPane.showMessageDialog(null, "Bill Table Created Successfully!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
