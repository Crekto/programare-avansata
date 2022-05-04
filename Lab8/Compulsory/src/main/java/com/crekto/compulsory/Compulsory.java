/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.compulsory;

import com.crekto.compulsory.classes.ContinentDAO;
import com.crekto.compulsory.classes.CountryDAO;
import com.crekto.compulsory.classes.Database;
import java.sql.SQLException;

/**
 *
 * @author hiimC
 */
public class Compulsory {

    public static void main(String[] args) {
        try {
            Database.createConnection();
            var continents = new ContinentDAO();
            continents.create("Europe");
            continents.create("America");
            Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");

            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }

    }
}
