package com.company.classes;

import com.company.interfaces.Identifiable;

public class Router extends Node implements Identifiable {
    private String ipAddress;

    public Router(String name, String macAddress, String location, String ipAddress) {
        super(name, macAddress, location);
        this.ipAddress = ipAddress;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", location='" + location + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                "}\n";
    }
}
