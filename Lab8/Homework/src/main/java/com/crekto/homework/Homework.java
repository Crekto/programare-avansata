/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.homework;

import com.crekto.homework.dao.CityDAO;
import com.crekto.homework.dao.ContinentDAO;
import com.crekto.homework.dao.CountryDAO;
import com.crekto.homework.dao.Database;
import com.crekto.homework.graphics.MainFrame;
import com.crekto.homework.util.CitiesDistance;
import com.crekto.homework.util.CityDataset;
import java.sql.SQLException;

/**
 *
 * @author hiimC
 */
public class Homework {

    public static void main(String[] args) {
        try {
            Database.createConnection();

            var continents = new ContinentDAO();
            /*
            continents.create("Europe");
            continents.create("Asia");
            Database.getConnection().commit();
             */

            //System.out.println(continents.findByName("Europe"));
            var countries = new CountryDAO();
            /*
            int europeId = continents.findByName("Europe").getId();
            int asiaId = continents.findByName("Asia").getId();

            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            countries.create("Andorra", europeId);
            countries.create("Bulgaria", europeId);
            countries.create("China", asiaId);
            countries.create("India", asiaId);
            countries.create("Israel", asiaId);
            Database.getConnection().commit();

            CityDataset.importCities("concap.csv");
            Database.getConnection().commit();
             */
            //System.out.println(countries.findByName("Romania"));

            var cities = new CityDAO();
            CitiesDistance.distance(cities.findByName("Bucharest"), cities.findByName("Sofia"));
            CitiesDistance.distance(cities.findByName("Andorra la Vella"), cities.findByName("Beijing"));
            CitiesDistance.distance(cities.findByName("Jerusalem"), cities.findByName("Kyiv"));
            CitiesDistance.distance(cities.findByName("New Delhi"), cities.findByName("Bucharest"));

            new MainFrame().setVisible(true);

            //Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
