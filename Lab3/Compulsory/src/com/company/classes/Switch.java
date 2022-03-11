package com.company.classes;

public class Switch extends Node {

    public Switch(String name, String macAddress, String location) {
        super(name, macAddress, location);
    }

    @Override
    public String toString() {
        return "Switch{" + "name='" + name + '\'' + ", macAddress='" + macAddress + '\'' + ", location='" + location + '\'' + "}\n";
    }
}
