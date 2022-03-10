package com.company.classes;

import java.util.Collections;
import java.util.Comparator;

public class RoomAssignmentSolution {
    private final RoomAssignmentProblem problem;

    public RoomAssignmentSolution(RoomAssignmentProblem problem) {
        this.problem = problem;
    }

    public void solution() {
        Collections.sort(problem.getEvents(), new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });

        Collections.sort(problem.getEvents(), new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.getEndTime() - o2.getEndTime() == 0) return o2.getSize() - o1.getSize();
                else return 0;
            }
        });

        Collections.sort(problem.getRooms(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o2.getCapacity() - o1.getCapacity();
            }
        });

        for (Event event : problem.getEvents()) {
            for (Room room : problem.getRooms()) {
                if (room.getCloesdTill() <= event.getStartTime() && room.getCapacity() >= event.getSize()) {
                    room.setCloesdTill(event.getEndTime());
                    System.out.println(event.getName() + " -> " + room.getId());
                    break;
                }
            }
        }
    }
}
