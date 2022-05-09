/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Customers {
    private int id;
    private String firstName;
    private String lastName;
    private String company;

    public static int getCount() throws Exception {
        ArrayList<Customers> list = new ArrayList();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stnt = con.createStatement();
        ResultSet rs = stnt.executeQuery("select count(*) as count from customers");
        int count = 0;
        while(rs.next())
        {
            count = rs.getInt("count");
        }
        rs.close();
        stnt.close();
        con.close();
        return count;
    }
    
    public static ArrayList<Customers> getList() throws Exception {
        ArrayList<Customers> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stnt = con.createStatement();
        ResultSet rs = stnt.executeQuery("select * from customers");
        while (rs.next()){
            int id = rs.getInt("CustomerId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            String company = rs.getString("Company");
        }
        rs.close();
        stnt.close();
        con.close();
        return list;
    }
    
    public Customers(int id, String firstName, String lastName, String company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    
}
