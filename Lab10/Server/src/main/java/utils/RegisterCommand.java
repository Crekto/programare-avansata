/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author hiimC
 */
public class RegisterCommand {

    public static String register(Database db, String name) {
        String response = new String();
        if (db.getUsers().contains(name)) {
            response = "User-ul [" + name + "] este deja inregistrat.";
        } else {
            db.addUser(name);
            db.getFriendships().put(name, new ArrayList<>());
            db.getMessages().put(name, new ArrayList<>());
            response = "User-ul [" + name + "] a fost inregistrat.";
        }
        return response;
    }

}
