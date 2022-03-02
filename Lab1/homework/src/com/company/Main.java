package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        if (args.length < 3) {
            System.err.println("Syntax error: <n - words> <p - characters> <C1 C2 ... Cm - Alphabet>");
            System.exit(0);
        }
        int n = 0, p = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println("First argument is not an Integer");
            System.exit(0);
        }
        try {
            p = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.err.println("Second argument is not an Integer");
            System.exit(0);
        }

        for (int i = 2; i < args.length; i++) {
            if (args[i].length() > 1 || Character.isLetter(args[i].charAt(0)) == false) {
                System.err.println("The given Alphabet doesn't contain letters only");
                System.exit(0);
            }
        }

        /* Generating words */
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuffer aux = new StringBuffer();
            for (int j = 0; j < p; j++) {
                aux.append(args[(int) Math.floor(Math.random() * (args.length - 1 - 2 + 1) + 2)]); //Math.floor(Math.random()*(max-min+1)+min)
            }
            words[i] = new String(aux);
        }
        System.out.println("Words: " + Arrays.toString(words) + "\n\n");

        /* Creating a boolean n x n matrix, representing the adjacency relation of the words */
        boolean[][] neighborAdjacency = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkNeighbor(words[i], words[j])) {
                    neighborAdjacency[i][j] = neighborAdjacency[j][i] = true;
                }
            }
        }

        /* Displaying the matrix */
        System.out.println("--==| Adjacency relation of the words |==--\n");
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(neighborAdjacency[i]));
        System.out.println("\n");

        /* Creating a data structure that stores the neighbors of each word */
        Neighbors[] storeNeighbors = new Neighbors[n];
        for (int i = 0; i < n; i++) {
            List<String> auxNeighbors = new ArrayList<String>();
            int noOfNeighbors = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && neighborAdjacency[i][j] == true) auxNeighbors.add(words[j]);
            }
            storeNeighbors[i] = new Neighbors(words[i], auxNeighbors);
        }

        long endTime = System.nanoTime();

        /* Displaying the data structure or running time in nanoseconds for larger n */
        if(n < 1000){
            System.out.println("--==| Data structure that stores the neighobrs of each word |==--\n");
            for (int i = 0; i < n; i++) {
                System.out.println("Word = " + storeNeighbors[i].getParent() + "     Neighbors = " + storeNeighbors[i].getNeighbors());
            }
        }
        else{
            System.out.println("Execution time: " + (endTime-startTime) + " nanoseconds");
        }



    }

    public static boolean checkNeighbor(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.contains(String.valueOf(s2.charAt(i))) == true) return true;
        }
        return false;
    }
}

class Neighbors {
    private final String parent;
    private List<String> neighbors = new ArrayList<String>();

    public Neighbors(String parent, List<String> neighbors) {
        this.parent = parent;
        this.neighbors = neighbors;
    }

    public String getParent() {
        return this.parent;
    }

    public List<String> getNeighbors() {
        return this.neighbors;
    }

}
