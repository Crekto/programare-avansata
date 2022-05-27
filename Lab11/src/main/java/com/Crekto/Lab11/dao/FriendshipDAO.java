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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> getTop(String number) throws SQLException {
        Connection con = Database.getConnection();
        Map<String, Integer> top = new HashMap<>();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select friend1, count(*) from friendships group by friend1 order by count(*) desc limit " + number)) {
            while (rs.next()) {
                top.put(rs.getString(1), rs.getInt(2));
            }
            return top;
        }
    }

}
