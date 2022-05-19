/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.crekto.server.threads.ClientThread;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hiimC
 */
public class MessageCommand {

    public static String send(Database db, String message, ClientThread ct) {
        List<String> friends = new ArrayList<>();
        friends = db.getFriendships().get(ct.getUsername());
        for (String friend : friends) {
            db.addMessage(friend, message);
        }
        return "Mesajele au fost transmise cu succes!";
    }

    public static String read(Database db, ClientThread ct) {
        List<String> messages = new ArrayList<>();
        messages = db.getMessages().get(ct.getUsername());

        if (messages.isEmpty()) {
            return "Nu ai niciun mesaj!";
        }

        return "Ai primit urmatoarele mesaje: " + messages;
    }

}
