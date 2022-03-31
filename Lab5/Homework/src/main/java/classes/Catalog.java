/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hiimC
 */
public class Catalog implements Serializable {

    String name;
    List<Item> items = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item findById(String id) {
        for (Item currItem : items) {
            if (currItem.getId().equals(id)) {
                return currItem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", items=" + items + '}';
    }

}
