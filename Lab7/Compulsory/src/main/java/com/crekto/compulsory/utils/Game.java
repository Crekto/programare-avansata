/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.compulsory.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hiimC
 */
public class Game {

    private final Bag bag = new Bag();
    private final Board board = new Board();
    //private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        //player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            Thread thread = new Thread();
            thread.start();
            //start a new thread

        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
