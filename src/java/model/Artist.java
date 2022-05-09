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
public class Artist {
    private int id;
    private String name;
    
    public static int getCount() throws Exception {
        ArrayList<Artist> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stnt = con.createStatement();
//        stnt.execute("insert ");
        ResultSet rs = stnt.executeQuery("select count(*) as count from artists");
        int count = 0;
        while (rs.next())
        {
            count = rs.getInt("count");
        }
        rs.close();
        stnt.close();
        con.close();
        return count;
    }
    
    public static ArrayList<Artist> getList() throws Exception {
        ArrayList<Artist> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stnt = con.createStatement();
//        stnt.execute("insert ");
        ResultSet rs = stnt.executeQuery("select * from artists");
        while (rs.next())
        {
            int id = rs.getInt("ArtistId");
            String name = rs.getString("Name");
            Artist a = new Artist(id, name);
            list.add(a);
        }
        rs.close();
        stnt.close();
        con.close();
        return list;
    }
    
    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}