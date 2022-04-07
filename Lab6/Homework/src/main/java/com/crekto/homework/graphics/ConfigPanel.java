/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.graphics;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author hiimC
 */
public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner spinner1;
    JSpinner spinner2;
    JButton createBtn = new JButton("Create");
    int rows, cols;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        rows = (int) spinner1.getValue();
        cols = (int) spinner2.getValue();

        createBtn.addActionListener(this::repaintDrawingPanel);
        //
        add(label);
        add(spinner1);
        add(spinner2);
        add(createBtn);
    }

    public void repaintDrawingPanel(ActionEvent e) {
        this.rows = (int) spinner1.getValue();
        this.cols = (int) spinner2.getValue();
        frame.getCanvas().init(this.rows, this.cols);
        frame.getCanvas().revalidate();
        frame.getCanvas().repaint();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
