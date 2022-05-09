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
public class Employees {
    private int id;
    private String firstName;
    private String lastName;

    public static int getCount() throws Exception {
        ArrayList<Employees> list = new ArrayList();
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
    
    public static ArrayList<Employees> getList() throws Exception {
        ArrayList<Employees> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stnt = con.createStatement();
        ResultSet rs = stnt.executeQuery("select * from employees");
        while (rs.next()){
            int id = rs.getInt("EmployeeId");
            String firstName = rs.getString("LastName");
            String lastName = rs.getString("FirstName");
        }
        rs.close();
        stnt.close();
        con.close();
        return list;
    }
    
    public Employees(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
