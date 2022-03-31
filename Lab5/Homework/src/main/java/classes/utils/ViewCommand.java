/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.utils;

import classes.Item;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiimC
 */
public class ViewCommand {

    public static void view(Item item) {
        if (item.getLocation().startsWith("http")) {
            try {
                Desktop.getDesktop().browse(new URI(item.getLocation()));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(ViewCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Desktop.getDesktop().open(new File(item.getLocation()));
            } catch (IOException ex) {
                Logger.getLogger(ViewCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
