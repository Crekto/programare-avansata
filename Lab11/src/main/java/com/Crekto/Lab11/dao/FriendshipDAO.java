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
public class FriendshipDAO {

    public void create(String myName, String friendName) throws SQLException {
        Connection con = Database.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement("insert into friendships (friend1, friend2) values (?, ?)")) {
            pstmt.setString(1, myName);
            pstmt.setString(2, friendName);
            pstmt.execute();
        }
    }

    public List<String> getFriendship(String name) throws SQLException {
        Connection con = Database.getConnection();
        List<String> friends = new ArrayList<>();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select friend2 from friendships where friend1 = '" + name + "'")) {
            while (rs.next()) {
                friends.add(rs.getString(1));

            }
            return friends;
        }
    }

}
