package com.company.classes;

import com.company.interfaces.Identifiable;
import com.company.interfaces.Storage;

public class Computer extends Node implements Identifiable, Storage {
    private String ipAddress;
    private long storageCapacity;

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
    public long getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Computer{" + "\n     name='" + name + '\'' + "\n     macAddress='" + macAddress + '\'' + "\n     location='" + location + '\'' + "\n     ipAddress='" + ipAddress + '\'' + "\n     storageCapacity=" + storageCapacity);
        return getString(result);
    }
}
