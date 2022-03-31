/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.utils;

import classes.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiimC
 */
public class LoadCommand {

    public static Catalog load(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
            return catalog;
        } catch (IOException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
