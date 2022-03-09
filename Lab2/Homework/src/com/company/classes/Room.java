package com.company.classes;

public abstract class Room {
    private int id;
    private int capacity;
    private int cloesdTill = -1;

    public Room(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
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


    public int getCloesdTill() {
        return cloesdTill;
    }

    public void setCloesdTill(int cloesdTill) {
        this.cloesdTill = cloesdTill;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && capacity == room.capacity;
    }

}
