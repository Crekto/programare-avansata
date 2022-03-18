

import classes.Intersection;
import classes.Street;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        var nodes = IntStream.rangeClosed(0, 8).mapToObj(i-> new Intersection("v"+i)).toArray(Intersection[]::new);

        List<Street> streets = new LinkedList<>();
        streets.add(new Street("s1", 2, nodes[0], nodes[1]));
        streets.add(new Street("s2", 2, nodes[0], nodes[2]));
        streets.add(new Street("s3", 2, nodes[0], nodes[3]));
        streets.add(new Street("s4", 2, nodes[1], nodes[2]));
        streets.add(new Street("s5", 3, nodes[1], nodes[4]));
        streets.add(new Street("s6", 2, nodes[2], nodes[6]));
        streets.add(new Street("s7", 2, nodes[2], nodes[5]));
        streets.add(new Street("s8", 3, nodes[3], nodes[5]));
        streets.add(new Street("s9", 1, nodes[4], nodes[5]));
        streets.add(new Street("s10", 1, nodes[4], nodes[7]));
        streets.add(new Street("s11", 2, nodes[4], nodes[8]));
        streets.add(new Street("s12", 1, nodes[6], nodes[7]));
        streets.add(new Street("s13", 1, nodes[6], nodes[8]));
        streets.add(new Street("s14", 1, nodes[7], nodes[8]));
        streets.add(new Street("s15", 3, nodes[5], nodes[8]));

        Collections.sort(streets, (o1, o2) -> o1.getLength() - o2.getLength());

        Set<Intersection> intersections = new HashSet<>();
        intersections.addAll(List.of(nodes));
    }


}