package com.company.classes;

import com.company.enums.OperatingSystems;

public class Lab extends Room {
    private OperatingSystems operatingSystem;

    public Lab(int id, int capacity, OperatingSystems operatingSystem) {
        super(id, capacity);
        this.operatingSystem = operatingSystem;
    }

    public OperatingSystems getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystems operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
