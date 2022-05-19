/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hiimC
 */
public class Database {

    List<String> users = new ArrayList<>();
    Map<String, List<String>> friendships = new HashMap<>();
    Map<String, List<String>> messages = new HashMap<>();

    public Database() {
    }

    public List<String> getUsers() {
        return users;
    }

    public Map<String, List<String>> getFriendships() {
        return friendships;
    }

    public Map<String, List<String>> getMessages() {
        return messages;
    }

    public void addUser(String name) {
        users.add(name);
    }

    public void addFriendship(String name, List<String> friends) {
        for (String friend : friends) {
            friendships.get(name).add(friend);
        }
    }

    public void addMessage(String name, String message) {
        messages.get(name).add(message);
    }

}
