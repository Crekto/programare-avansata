/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crekto.Lab11.controllers;

import com.Crekto.Lab11.dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hiimC
 */
@RestController
@RequestMapping("/users")
public class UserController {

    UserDAO users = new UserDAO();

    @GetMapping()
    public List<String> getPersons() throws SQLException {
        return users.getAllUsers();
    }

    @PostMapping("/new/{name}")
    public List<String> addUser(@PathVariable String name) throws SQLException {
        users.create(name);
        return users.getAllUsers();
    }

    @PutMapping("/rename/{oldName}/{newName}")
    public List<String> renameUser(@PathVariable String oldName, @PathVariable String newName) throws SQLException {
        users.renameUser(oldName, newName);
        return users.getAllUsers();
    }

    @DeleteMapping("/remove/{name}")
    public List<String> deleteUser(@PathVariable String name) throws SQLException {
        users.deleteUser(name);
        return users.getAllUsers();
    }

}
