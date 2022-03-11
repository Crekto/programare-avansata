package com.company.classes;

import com.company.interfaces.Identifiable;
import com.company.interfaces.Storage;

public class Computer extends Node implements Identifiable, Storage {
    private String ipAddress;
    private int storageCapacity;

    public Computer(String name, String macAddress, String location, String ipAddress, int storageCapacity) {
        super(name, macAddress, location);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" + "ipAddress='" + ipAddress + '\'' + ", storageCapacity=" + storageCapacity + ", name='" + name + '\'' + ", macAddress='" + macAddress + '\'' + ", location='" + location + '\'' + "}\n";
    }
}
