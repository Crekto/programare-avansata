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
public class FriendCommand {

    public static String friend(Database db, ClientThread ct, String friends) {
        String[] friend = friends.split(" ");
        List<String> registeredFriends = new ArrayList<>();
        List<String> notRegisteredFriends = new ArrayList<>();
        boolean selfFriend = false;

        String response = new String();
        if (ct.isLoggedIn() == false) {
            response = "Nu esti logat!";
        } else {
            for (String fr : friend) {
                if (ct.getUsername().equals(fr)) {
                    selfFriend = true;
                } else if (db.getUsers().contains(fr)) {
                    registeredFriends.add(fr);
                } else {
                    notRegisteredFriends.add(fr);
                }
            }
            if (selfFriend) {
                response = "Nu te poti adauga singur la prieteni!";
            } else if (!notRegisteredFriends.isEmpty()) {
                response = "Urmatoarele persoane nu putut fi adaugate deoarece nu sunt inregistrate: " + notRegisteredFriends;
            } else {
                db.addFriendship(ct.getUsername(), registeredFriends);
                response = "Ti-au fost adaugate relatiile de prietenie cu urmatoarele persoane: " + registeredFriends;
            }
        }
        return response;
    }

}
