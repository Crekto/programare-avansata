/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.compulsory;

import com.crekto.compulsory.classes.Catalog;
import com.crekto.compulsory.classes.CatalogUtil;
import com.crekto.compulsory.classes.Item;

/**
 *
 * @author hiimC
 */
public class Compulsory {

    public static void main(String[] args) {
        Compulsory app = new Compulsory();
        Item i1 = new Item("knuth67", "The Art of Computer Programming", "https://www.google.com");
        Item i2 = new Item("java17", "The Java Language Specification", "https://www.google.com");

        Catalog cat = new Catalog("test");
        CatalogUtil catUtil = new CatalogUtil();
        CatalogUtil.add(cat, i1);
        CatalogUtil.add(cat, i1);

        CatalogUtil.save(cat, "catalog.json");
        CatalogUtil.load("catalog.json");

    }
}
