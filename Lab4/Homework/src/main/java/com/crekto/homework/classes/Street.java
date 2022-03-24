/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.classes;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Street other = (Street) obj;
        if (this.length != other.length) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.intersection1, other.intersection1)) {
            return false;
        }
        return Objects.equals(this.intersection2, other.intersection2);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.length;
        hash = 79 * hash + Objects.hashCode(this.intersection1);
        hash = 79 * hash + Objects.hashCode(this.intersection2);
        return hash;
    }

    @Override
    public String toString() {
        return "Street{" + "name=" + name + ", length=" + length + ", joins intersection " + intersection1 + " and " + intersection2 + "}";
    }

}
