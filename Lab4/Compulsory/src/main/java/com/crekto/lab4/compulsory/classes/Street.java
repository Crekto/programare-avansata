/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.lab4.compulsory.classes;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hiimC
 */
public class Street {
    String name;
    int length;
    Intersection intersection1;
    Intersection intersection2;

    public Street(String name, int length, Intersection intersection1, Intersection intersection2) {
        this.name = name;
        this.length = length;
        this.intersection1 = intersection1;
        this.intersection2 = intersection2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getIntersection1() {
        return intersection1;
    }

    public void setIntersection1(Intersection intersection1) {
        this.intersection1 = intersection1;
    }

    public Intersection getIntersection2() {
        return intersection2;
    }

    public void setIntersection2(Intersection intersection2) {
        this.intersection2 = intersection2;
    }

    
    

}
