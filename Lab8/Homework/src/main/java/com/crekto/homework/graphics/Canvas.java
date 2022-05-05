/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.graphics;

import com.crekto.homework.dao.CountryDAO;
import com.crekto.homework.dao.Database;
import com.crekto.homework.locations.City;
import com.crekto.homework.util.SphericalMercator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author hiimC
 */
public class Canvas extends JPanel {

    private final MainFrame frame;

    public Canvas(MainFrame frame) {
        this.frame = frame;
    }

    final void init() {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        try {
            BufferedImage mapImage = ImageIO.read(new File("mercator700.jpg"));
            graphics.drawImage(mapImage, 0, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graphics2D g = (Graphics2D) graphics;
        try {
            paintCities(g);
        } catch (SQLException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void paintCities(Graphics2D g) throws SQLException {
        Connection con = Database.getConnection();
        try ( Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery("select * from cities")) {
            SphericalMercator sphericalMercator = new SphericalMercator();
            g.setColor(Color.red);
            while (rs.next()) {
                //g.fillOval((int) ( ( sphericalMercator.xAxisProjection(rs.getDouble(6)) + 20037508.34 ) / 57250.0238286 ), (int) ( ( sphericalMercator.xAxisProjection(rs.getDouble(5)) + 23810769.32 ) / 68030.7694857 ), 5, 5);
                g.fillOval((int) ( ( sphericalMercator.xAxisProjection(rs.getDouble(6)) + 20037508.34 ) / 57250.0238286 - 5 ), (int) ( 685 - ( sphericalMercator.xAxisProjection(rs.getDouble(5)) + 23810769.32 ) / 68030.7694857 ), 10, 10);
            }
        }
    }

}
