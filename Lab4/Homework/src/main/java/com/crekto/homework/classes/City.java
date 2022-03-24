/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hiimC
 */
public class City {

    List<Street> streets = new ArrayList<>();
    Set<Intersection> intersections = new HashSet<>();
    Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public City(List<Street> streets, Set<Intersection> intersections) {
        this.streets = streets;
        Collections.sort(streets, (o1, o2) -> o1.getLength() - o2.getLength());
        this.intersections = intersections;
        for (Intersection currIntersection : intersections) {
            List<Street> auxStreets = new ArrayList<>();
            for (Street currStreet : streets) {
                if (currStreet.getIntersection1().equals(currIntersection) || currStreet.getIntersection2().equals(currIntersection)) {
                    auxStreets.add(currStreet);
                }
            }
            cityMap.put(currIntersection, auxStreets);
        }
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    public void addStreet(Street street) {
        streets.add(street);
        Collections.sort(streets, (o1, o2) -> o1.getLength() - o2.getLength());
    }

    public Set<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(Set<Intersection> intersections) {
        this.intersections = intersections;
    }

    public void addIntersection(Intersection intersection) {
        intersections.add(intersection);
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public void displayDesiredStreets(int length) {
        System.out.println("\nThe streets that are longer than " + length + " and joins at least 3 streets are:\n");
        List<Street> streetsAux = streets.stream().filter(street -> street.getLength() > length).filter(street -> ( cityMap.get(street.getIntersection1()).size() + cityMap.get(street.getIntersection2()).size() - 2 >= 3 )).collect(Collectors.toList());
        for (Street currStreet : streetsAux) {
            System.out.println(currStreet);
        }
    }

    public int[][] generateAdjacenyMatrix() {
        int noOfIntersections = intersections.size();
        int[][] adjacencyMatrix = new int[noOfIntersections][noOfIntersections];

        // Am facut o mapa in care ii asociez fiecarei intersectie o pozitie pentru a crea matricea de adiacenta
        Map<Intersection, Integer> intersectionNumbering = new HashMap<>();
        Integer numbering = 0;
        for (Intersection currIntersection : intersections) {
            intersectionNumbering.put(currIntersection, numbering);
            numbering++;
        }

        for (Street currStreet : streets) {
            int intersection1 = intersectionNumbering.get(currStreet.getIntersection1());
            int intersection2 = intersectionNumbering.get(currStreet.getIntersection2());
            adjacencyMatrix[intersection1][intersection2] = adjacencyMatrix[intersection2][intersection1] = currStreet.getLength();
        }

        return adjacencyMatrix;
    }

    public void primMST() {
        int[][] adjacencyMatrix = generateAdjacenyMatrix();
        int totalIntersections = intersections.size();

        int noOfIntersection = 0;
        boolean[] isVisited = new boolean[totalIntersections];
        isVisited[0] = true;

        System.out.println("\nThe total cost is minimum over the following streets:\n");
        while (noOfIntersection < totalIntersections - 1) {
            int min = Integer.MAX_VALUE;
            int minCurr = 0, minNext = 0;

            for (int i = 0; i < totalIntersections; i++) {
                if (isVisited[i]) {
                    for (int j = 0; j < totalIntersections; j++) {
                        if (!isVisited[j] && adjacencyMatrix[i][j] > 0 && min > adjacencyMatrix[i][j]) {
                            min = adjacencyMatrix[i][j];
                            minCurr = i;
                            minNext = j;
                        }
                    }
                }
            }
            isVisited[minNext] = true;
            noOfIntersection++;
            //Numerical node to node + Length
            System.out.println("Street: " + minCurr + " - " + minNext + " | Length: " + min);

            //Name of street the + Length
            /*
            final var minCurrAux = minCurr;
            final var minNextAux = minNext;
            streets.stream().filter(street -> ( street.getIntersection1().equals(( intersections.toArray()[minCurrAux] )) && street.getIntersection2().equals(( intersections.toArray()[minNextAux] )) ) || ( street.getIntersection2().equals(( intersections.toArray()[minCurrAux] )) && street.getIntersection1().equals(( intersections.toArray()[minNextAux] )) )
            ).forEach(street -> System.out.printf("Street: %-30s Length: %s %n", street.getName(), street.getLength()));
             */
        }

    }

    @Override
    public String toString() {
        return "City{streets=" + streets + ", intersections=" + intersections + '}';
    }

}
