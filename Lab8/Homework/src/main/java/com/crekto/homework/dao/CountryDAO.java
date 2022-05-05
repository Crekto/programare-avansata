/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.dao;

import com.crekto.homework.locations.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiimC
 */
public class CountryDAO {

    public void create(String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into countries(name,continent) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public Country findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from countries where name='" + name + "'")) {
            var continent = new ContinentDAO();
            return rs.next() ? new Country(rs.getInt(1), rs.getString(2), rs.getString(3), continent.findById(rs.getInt(4))) : null;
        }
    }

    public Country findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from countries where id='" + id + "'")) {
            var continent = new ContinentDAO();
            return rs.next() ? new Country(rs.getInt(1), rs.getString(2), rs.getString(3), continent.findById(rs.getInt(4))) : null;
        }

    }
}
