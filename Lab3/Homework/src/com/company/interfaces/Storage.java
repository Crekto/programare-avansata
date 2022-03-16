package com.company.interfaces;

import com.company.enums.UnitsOfStorage;

public interface Storage {
    long getStorageCapacity();

    default long getStorageCapacity(UnitsOfStorage unit) {
        if (unit == UnitsOfStorage.MB) return getStorageCapacity() * 1024;
        if (unit == UnitsOfStorage.KB) return getStorageCapacity() * 1024 * 1024;
        if (unit == UnitsOfStorage.B) return getStorageCapacity() * 1024 * 1024 * 1024;
        return getStorageCapacity();
    }

}
