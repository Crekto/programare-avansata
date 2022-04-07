/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.gameUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hiimC
 */
public class GameGrid implements Serializable {

    int rows;
    int cols;
    List<List<Integer>> gameGrid;

    public GameGrid() {
    }

    public GameGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gameGrid = new ArrayList<>(rows * cols);
        generateGrid();
    }

    private void generateGrid() {
        for (int node = 0; node < rows * cols; node++) {
            gameGrid.add(new ArrayList<>());

            if (node != 0 && node % cols != 0) {
                if (trueOrFalse()) {
                    addEdge(node, node - 1);
                }
            }

            if (node / cols > 0) {
                if (trueOrFalse()) {
                    addEdge(node, node - cols);
                }
            }
        }
    }

    private boolean trueOrFalse() {
        Random rnd = new Random();
        int aux = rnd.nextInt(100);
        return aux < 65;
    }

    private void addEdge(int i, int j) {
        gameGrid.get(i).add(j);
        gameGrid.get(j).add(i);
    }

    public List<List<Integer>> getGameGrid() {
        return gameGrid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setGameGrid(List<List<Integer>> gameGrid) {
        this.gameGrid = gameGrid;
    }

}
