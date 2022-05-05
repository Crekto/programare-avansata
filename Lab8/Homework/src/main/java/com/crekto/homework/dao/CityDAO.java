/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.dao;

import com.crekto.homework.locations.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiimC
 */
public class CityDAO {

    public void create(String name, int country, boolean capital, double latitude, double longitude) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into cities (country, name, capital, latitude, longitude) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, country);
            pstmt.setString(2, name);
            pstmt.setBoolean(3, capital);
            pstmt.setDouble(4, latitude);
            pstmt.setDouble(5, longitude);
            pstmt.executeUpdate();
        }
    }

    public City findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from cities where name='" + name + "'")) {
            var country = new CountryDAO();
            return rs.next() ? new City(rs.getInt(1), country.findById(rs.getInt(2)), rs.getString(3), rs.getBoolean(4), rs.getDouble(5), rs.getDouble(6)) : null;
        }
    }

    public City findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from cities where id='" + id + "'")) {
            var country = new CountryDAO();
            return rs.next() ? new City(rs.getInt(1), country.findById(rs.getInt(2)), rs.getString(3), rs.getBoolean(4), rs.getDouble(5), rs.getDouble(6)) : null;
        }
    }
}
