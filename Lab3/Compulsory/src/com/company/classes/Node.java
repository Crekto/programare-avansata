package com.company.classes;

public abstract class Node {
    String name;
    String macAddress;
    String location;

    public Node(String name, String macAddress, String location) {
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", location='" + location + '\'' +
                "}\n";
    }
}
