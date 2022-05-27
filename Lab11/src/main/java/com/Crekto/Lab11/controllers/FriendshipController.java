/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crekto.Lab11.controllers;

import com.Crekto.Lab11.dao.FriendshipDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hiimC
 */
@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    FriendshipDAO friendships = new FriendshipDAO();

    @GetMapping("/{name}")
    public List<String> getFriendships(@PathVariable String name) throws SQLException {
        return friendships.getFriendship(name);
    }

    @PostMapping("/new/{firstUser}/{secondUser}")
    public List<String> addFriendship(@PathVariable String firstUser, @PathVariable String secondUser) throws SQLException {
        friendships.create(firstUser, secondUser);
        return friendships.getFriendship(firstUser);
    }

    @GetMapping("/top/{number}")
    public Map<String, Integer> getTopFriendship(@PathVariable String number) throws SQLException {
        return friendships.getTop(number);
    }

}
