/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.gameUtils;

import com.crekto.homework.graphics.DrawingPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author hiimC
 */
public class MouseListener implements MouseInputListener {

    DrawingPanel drawingPanel;

    public MouseListener(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Stone stone : drawingPanel.getStones()) {
            if (stone.getActualStone().contains(e.getPoint())) {
                GameController gameController = drawingPanel.getFrame().getGameController();
                List<List<Integer>> gameGrid = gameController.getNewGameGrid().getGameGrid();

                if (gameController.isGameOver()) {
                    System.err.println("[Error] Jocul s-a terminat deja.");
                    return;
                }

                if (!isValidMove(gameGrid, gameController, stone.getStoneId())) {
                    System.err.println("[Error] Acest nod nu este adiacent cu piatra selectata anterior.");
                    return;
                }

                if (gameGrid.get(stone.getStoneId()).isEmpty()) {
                    System.err.println("[Error] Nu poti plasa piatra aici deoarece intersectia nu este conectata cu niciun bat.");
                    return;
                }

                if (stone.getSelectedByPlayer() != 0) {
                    System.err.println("[Error] Acest loc a fost deja selectat");
                    return;
                }

                boolean player1Round = gameController.isPlayer1Round();
                if (player1Round) {
                    stone.setStoneFillColor(Color.red);
                    stone.setSelectedByPlayer(1);
                } else {
                    stone.setStoneFillColor(Color.blue);
                    stone.setSelectedByPlayer(2);
                }
                gameController.setCurrentlySelectedStone(stone.getStoneId());
                gameController.addSelectedStone(stone.getStoneId());
                if (isEnded(gameGrid, gameController)) {
                    if (player1Round) {
                        System.out.println("Jocul s-a terminat, jucatorul ROSU a castigat.");
                    } else {
                        System.out.println("Jocul s-a terminat, jucatorul ALBASTRU a castigat.");
                    }
                    gameController.setGameOver(true);
                }
                gameController.setPlayer1Round(!player1Round);
                drawingPanel.revalidate();
                drawingPanel.repaint();

            }
        }
    }

    private boolean isEnded(List<List<Integer>> gameGrid, GameController gameController) {
        int currentlySelectedStone = gameController.getCurrentlySelectedStone();
        for (int j = 0; j < gameGrid.get(currentlySelectedStone).size(); j++) {
            if (!gameController.getSelectedStones().contains(gameGrid.get(currentlySelectedStone).get(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidMove(List<List<Integer>> gameGrid, GameController gameController, int id) {
        int currentlySelectedStone = gameController.getCurrentlySelectedStone();
        if (currentlySelectedStone == -1) {
            return true;
        }
        return gameGrid.get(currentlySelectedStone).contains(id);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

}
