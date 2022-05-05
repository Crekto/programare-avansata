/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.locations;

/**
 *
 * @author hiimC
 */
public class Country {

    int id;
    String name;
    String code;
    Continent continent;

    public Country(int id, String name, String code, Continent continent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", code=" + code + ", continent=" + continent + '}';
    }
}
