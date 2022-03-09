package com.company.classes;

public class LectureHall extends Room {
    private boolean hasProjector;

    public LectureHall(int id, int capacity, boolean hasProjector) {
        super(id, capacity);
        this.hasProjector = hasProjector;
    }

    public boolean getHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }
}
