/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.util;

import com.crekto.homework.dao.CityDAO;
import com.crekto.homework.dao.CountryDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiimC
 */
public abstract class CityDataset {

    public static void importCities(String path) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            var cities = new CityDAO();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] columns = line.split(",");

                var country = new CountryDAO();
                try {
                    if (country.findByName(columns[0]) != null) {
                        System.out.println(columns[0] + columns[1] + columns[2]);
                        cities.create(columns[1], country.findByName(columns[0]).getId(), true, Double.parseDouble(columns[2]), Double.parseDouble(columns[3]));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CityDataset.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CityDataset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
