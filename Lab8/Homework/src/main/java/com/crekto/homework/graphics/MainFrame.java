/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.graphics;

import static java.awt.BorderLayout.CENTER;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author hiimC
 */
public class MainFrame extends JFrame {

    Canvas canvas;

    public MainFrame() {
        super("Lab8 Homework");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new Canvas(this);
        this.setSize(700, 700);
        add(canvas, CENTER);
        //pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}
