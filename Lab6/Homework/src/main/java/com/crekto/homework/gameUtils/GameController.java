/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.gameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiimC
 */
public class GameController implements Serializable {

    boolean gameStarted;
    boolean gameOver;
    boolean player1Round;
    int currentlySelectedStone = -1;
    List<Integer> selectedStones = new ArrayList<>();
    List<Stone> stones = new ArrayList<>();
    GameGrid newGameGrid = new GameGrid();

    public GameController() {
        this.gameStarted = false;
        this.gameOver = false;
        this.player1Round = true;
    }

    public void restartGame() {
        stones.clear();
        gameStarted = false;
        gameOver = false;
        player1Round = true;
        currentlySelectedStone = -1;
        selectedStones.clear();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isPlayer1Round() {
        return player1Round;
    }

    public void setPlayer1Round(boolean player1Round) {
        this.player1Round = player1Round;
    }

    public int getCurrentlySelectedStone() {
        return currentlySelectedStone;
    }

    public void setCurrentlySelectedStone(int currentlySelectedStone) {
        this.currentlySelectedStone = currentlySelectedStone;
    }

    public void addSelectedStone(Integer id) {
        selectedStones.add(id);
    }

    public List<Integer> getSelectedStones() {
        return selectedStones;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public List<Stone> getStones() {
        return stones;
    }

    public void setStones(List<Stone> stones) {
        this.stones = stones;
    }

    public GameGrid getNewGameGrid() {
        return newGameGrid;
    }

    public void setNewGameGrid(GameGrid newGameGrid) {
        this.newGameGrid = newGameGrid;
    }

    public void setSelectedStones(List<Integer> selectedStones) {
        this.selectedStones = selectedStones;
    }

    public void save() {
        try {
            FileOutputStream file = new FileOutputStream(new File("saved.idk"));
            ObjectOutputStream objStream = new ObjectOutputStream(file);

            objStream.writeObject(gameStarted);
            objStream.writeObject(gameOver);
            objStream.writeObject(player1Round);
            objStream.writeObject(currentlySelectedStone);
            objStream.writeObject(selectedStones);
            objStream.writeObject(stones);
            objStream.writeObject(newGameGrid);

            objStream.close();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
        try {
            FileInputStream file = new FileInputStream(new File("saved.idk"));
            ObjectInputStream objStream = new ObjectInputStream(file);

            gameStarted = (boolean) objStream.readObject();
            gameOver = (boolean) objStream.readObject();
            player1Round = (boolean) objStream.readObject();
            currentlySelectedStone = (int) objStream.readObject();
            selectedStones = (List<Integer>) objStream.readObject();
            stones = (List<Stone>) objStream.readObject();
            newGameGrid = (GameGrid) objStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
