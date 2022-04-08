/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.compulsory.utils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hiimC
 */
public class Board {

    private final Set<String> words = new HashSet<>();

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }

    public Set<String> getWords() {
        return words;
    }

}
