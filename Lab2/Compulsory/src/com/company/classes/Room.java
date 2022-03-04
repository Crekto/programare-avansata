package com.company.classes;

import com.company.enums.Type;

public class Room {
    private int id;
    private int capacity;
    private Type type;

    public Room(int id, int capacity, Type type) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }
}
