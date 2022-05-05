/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.dao;

import com.crekto.homework.locations.Continent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiimC
 */
public class ContinentDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into continents (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Continent findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from continents where name='" + name + "'")) {
            return rs.next() ? new Continent(rs.getInt(1), rs.getString(2)) : null;
        }
    }

    public Continent findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from continents where id='" + id + "'")) {
            return rs.next() ? new Continent(rs.getInt(1), rs.getString(2)) : null;
        }
    }
}
