/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.homework;

import classes.Catalog;
import classes.Item;
import classes.utils.AddCommand;
import classes.utils.InfoCommand;
import classes.utils.ListCommand;
import classes.utils.LoadCommand;
import classes.utils.ReportCommand;
import classes.utils.SaveCommand;
import classes.utils.ViewCommand;

/**
 *
 * @author hiimC
 */
public class Homework {

    public static void main(String[] args) {
        Homework app = new Homework();
        Item i1 = new Item("knuth67", "The Art of Computer Programming", "https://www.google.com");
        Item i2 = new Item("java17", "The Java Language Specification", "test.json");
        Item i3 = new Item("imageTest", "The Java Language Specification", "imageTest.jpg");

        Catalog cat = new Catalog("Catalogul meu");
        AddCommand.add(cat, i1);
        AddCommand.add(cat, i2);
        AddCommand.add(cat, i3);
        SaveCommand.save(cat, "test.json");

        //cat = LoadCommand.load("test.json");
        ListCommand.list(cat);
        //ViewCommand.view(cat.findById("java17"));
        ReportCommand.report(cat);
        InfoCommand.info(cat.findById("imageTest"));
    }
}
