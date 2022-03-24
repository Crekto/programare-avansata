/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.homework;

import com.crekto.homework.classes.City;
import com.crekto.homework.classes.Intersection;
import com.crekto.homework.classes.Street;
import com.github.javafaker.Faker;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author hiimC
 */
public class Homework {

    public static void main(String[] args) {
        Faker faker = new Faker();

        var nodes = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection(faker.funnyName().name())).toArray(Intersection[]::new);

        List<Street> streets = new LinkedList<>();
        streets.add(new Street(faker.address().streetName(), 2, nodes[0], nodes[1]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[0], nodes[2]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[0], nodes[3]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[1], nodes[2]));
        streets.add(new Street(faker.address().streetName(), 3, nodes[1], nodes[4]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[2], nodes[3]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[2], nodes[6]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[2], nodes[5]));
        streets.add(new Street(faker.address().streetName(), 3, nodes[3], nodes[5]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[4], nodes[5]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[4], nodes[7]));
        streets.add(new Street(faker.address().streetName(), 2, nodes[4], nodes[8]));
        streets.add(new Street(faker.address().streetName(), 3, nodes[5], nodes[8]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[6], nodes[7]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[6], nodes[8]));
        streets.add(new Street(faker.address().streetName(), 1, nodes[7], nodes[8]));

        Set<Intersection> intersections = new LinkedHashSet<>();
        intersections.addAll(List.of(nodes));

        City Iasi = new City(streets, intersections);
        Iasi.displayDesiredStreets(2);
        Iasi.primMST();

    }
}
