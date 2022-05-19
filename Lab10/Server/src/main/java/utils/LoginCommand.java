/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.crekto.server.threads.ClientThread;

/**
 *
 * @author hiimC
 */
public class LoginCommand {

    public static String login(Database db, String name, ClientThread ct) {
        String response = new String();
        if (ct.isLoggedIn() == true) {
            response = "Esti deja logat!";
        } else if (db.getUsers().contains(name)) {
            response = "Te-ai logat cu succes!";
            ct.setUsername(name);
            ct.setLoggedIn(true);
        } else {
            response = "User-ul [" + name + "] nu este inregistrat, pentru a-l inregistra folosete comanda `register {nume}`.";
        }
        return response;
    }

}
