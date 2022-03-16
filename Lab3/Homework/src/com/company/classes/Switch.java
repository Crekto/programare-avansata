package com.company.classes;

public class Switch extends Node {

    public Switch(String name, String macAddress, String location) {
        super(name, macAddress, location);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Switch{" + "\n     name='" + name + '\'' + "\n     macAddress='" + macAddress + '\'' + "\n     location='" + location + '\'');
        return getString(result);
    }
}
