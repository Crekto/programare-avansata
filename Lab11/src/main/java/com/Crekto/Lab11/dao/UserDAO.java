/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crekto.Lab11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hiimC
 */
public class UserDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into users (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.execute();
        }
    }

    public void renameUser(String oldName, String newName) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("update users set name = ? where name = ?")) {
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);
            pstmt.execute();
        }
    }

    public void deleteUser(String name) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("delete from users where name = ?")) {
            pstmt.setString(1, name);
            pstmt.execute();
        }
    }

    public List<String> getAllUsers() throws SQLException {
        Connection con = Database.getConnection();
        List<String> users = new ArrayList<>();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from users")) {
            while (rs.next()) {
                users.add(rs.getString(2));

            }
            return users;
        }
    }

}
