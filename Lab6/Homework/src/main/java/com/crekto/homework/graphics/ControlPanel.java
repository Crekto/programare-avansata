/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author hiimC
 */
public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    JButton saveImageBtn = new JButton("Save as PNG");
    //

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(2, 2));

        //
        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener((ActionEvent e) -> {
            frame.getGameController().save();
        });
        loadBtn.addActionListener((ActionEvent e) -> {
            frame.getGameController().load();
            frame.getCanvas().revalidate();
            frame.getCanvas().repaint();
        });
        saveImageBtn.addActionListener((ActionEvent e) -> {
            frame.savePNG();
        });
        //
        add(saveBtn);
        add(loadBtn);
        add(saveImageBtn);
        add(exitBtn);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
