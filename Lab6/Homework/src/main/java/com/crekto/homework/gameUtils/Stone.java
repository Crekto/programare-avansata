/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.gameUtils;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 *
 * @author hiimC
 */
public class Stone implements Serializable {

    Color stoneFillColor;
    Ellipse2D actualStone;
    int selectedByPlayer = 0;
    int stoneId;
    int stoneSize = 20;

    public Stone(Color stoneFillColor, int stoneId, int x, int y) {
        this.stoneFillColor = stoneFillColor;
        this.stoneId = stoneId;
        this.actualStone = new Ellipse2D.Double(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
    }

    public Color getStoneFillColor() {
        return stoneFillColor;
    }

    public void setStoneFillColor(Color stoneFillColor) {
        this.stoneFillColor = stoneFillColor;
    }

    public Ellipse2D getActualStone() {
        return actualStone;
    }

    public void setActualStone(Ellipse2D actualStone) {
        this.actualStone = actualStone;
    }

    public int getSelectedByPlayer() {
        return selectedByPlayer;
    }

    public void setSelectedByPlayer(int selectedByPlayer) {
        this.selectedByPlayer = selectedByPlayer;
    }

    public int getStoneId() {
        return stoneId;
    }

    public void setStoneId(int stoneId) {
        this.stoneId = stoneId;
    }

    public int getStoneSize() {
        return stoneSize;
    }

    public void setStoneSize(int stoneSize) {
        this.stoneSize = stoneSize;
    }

}
