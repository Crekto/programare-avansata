package com.company;

import com.company.classes.*;
import com.company.enums.OperatingSystems;

public class Main {
    public static void main(String[] args) {

        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);

        Lab R1 = new Lab(401, 30, OperatingSystems.Windows);
        Lab R2 = new Lab(403, 30, OperatingSystems.Android);
        Lab R3 = new Lab(405, 30, OperatingSystems.Linux);
        Room R4 = new LectureHall(309, 100, true);
        RoomAssignmentProblem Problem1 = new RoomAssignmentProblem();

        Problem1.addObject(C1);
        Problem1.addObject(C2);
        Problem1.addObject(L1);
        Problem1.addObject(L2);
        Problem1.addObject(L3);

        Problem1.addObject(R1);
        Problem1.addObject(R2);
        Problem1.addObject(R3);
        Problem1.addObject(R4);

        RoomAssignmentSolution solution1 = new RoomAssignmentSolution(Problem1);
        solution1.solution();

    }
}
