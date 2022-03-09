package com.company.classes;

import java.util.ArrayList;

public class RoomAssignmentProblem {
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomAssignmentProblem() {
    }

    public RoomAssignmentProblem(ArrayList<Event> events, ArrayList<Room> rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public boolean alreadyContainsObject(Object obj) {
        if (obj instanceof Event) {
            for (Event event : events) {
                if (event.equals(obj)) return true;
            }
        } else if (obj instanceof Room) {
            for (Room room : rooms) {
                if (room.equals(obj)) return true;
            }
        }
        return false;
    }

    public void addObject(Object obj) {
        if (alreadyContainsObject(obj)) {
            System.err.println("The object - " + obj + " - is already added to this problem.");
        } else if (obj instanceof Event) {
            events.add((Event) obj);
        } else if (obj instanceof Room) {
            rooms.add((Room) obj);
        } else System.err.println("The object - " + obj + " - is not valid for this problem.");
    }

    @Override
    public String toString() {
        return "RoomAssignmentProblem {\n" + "   events=" + events + "\n   rooms=" + rooms + "\n}";
    }
}
