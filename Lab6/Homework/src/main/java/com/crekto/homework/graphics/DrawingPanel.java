/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.graphics;

import com.crekto.homework.gameUtils.GameController;
import com.crekto.homework.gameUtils.GameGrid;
import com.crekto.homework.gameUtils.MouseListener;
import com.crekto.homework.gameUtils.Stone;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author hiimC
 */
public class DrawingPanel extends JPanel {

    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    List<Stone> stones = new ArrayList<>();
    GameGrid newGameGrid;
    GameController gameController;

    public DrawingPanel(MainFrame frame) {
        this.addMouseListener(new MouseListener(this));
        this.frame = frame;
        this.gameController = frame.getGameController();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = 30;
        this.padY = 30;
        this.cellWidth = ( canvasWidth - 2 * padX ) / ( cols - 1 );
        this.cellHeight = ( canvasHeight - 2 * padY ) / ( rows - 1 );
        this.boardWidth = ( cols - 1 ) * cellWidth;
        this.boardHeight = ( rows - 1 ) * cellHeight;

        gameController.restartGame();

        //generated first set of stones which are not selected
        int stoneId = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                stones.add(new Stone(Color.DARK_GRAY, stoneId++, x, y));
            }
        }
        gameController.setStones(stones);

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintSticks(g);
        paintGrid(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines TODO
        for (int col = 0; col < cols; col++) {
            int y1 = padY;
            int x1 = padY + col * cellWidth;
            int x2 = x1;
            int y2 = padX + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        stones = gameController.getStones();
        for (Stone stone : stones) {
            if (stone.getSelectedByPlayer() == 0) {
                g.setColor(Color.DARK_GRAY);
                g.draw(stone.getActualStone());
            } else {
                g.setColor(stone.getStoneFillColor());
                g.fill(stone.getActualStone());
            }
        }
    }

    private void paintSticks(Graphics2D g) {
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(4));

        if (!frame.getGameController().isGameStarted()) {
            newGameGrid = new GameGrid(rows, cols);
            gameController.setNewGameGrid(newGameGrid);
        }
        gameController.setGameStarted(true);
        List<List<Integer>> gameGrid = gameController.getNewGameGrid().getGameGrid(); //adjacency list
        for (int i = 0; i < gameGrid.size(); i++) {
            for (int j = 0; j < gameGrid.get(i).size(); j++) {
                int x1 = padX + ( i % cols ) * cellWidth;
                int y1 = padY + ( i / cols ) * cellHeight;
                int x2 = padX + ( gameGrid.get(i).get(j) % cols ) * cellWidth;
                int y2 = padY + ( gameGrid.get(i).get(j) / cols ) * cellHeight;
                g.drawLine(x1, y1, x2, y2);
            }
        }

    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public List<Stone> getStones() {
        return stones;
    }

    public GameGrid getNewGameGrid() {
        return newGameGrid;
    }

}
