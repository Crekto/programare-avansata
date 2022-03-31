/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.utils;

import classes.Catalog;
import classes.Item;

/**
 *
 * @author hiimC
 */
public class AddCommand {

    public static void add(Catalog catalog, Item item) {
        catalog.getItems().add(item);
    }
}
