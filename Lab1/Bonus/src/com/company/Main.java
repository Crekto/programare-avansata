package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static String[] words;
    static boolean[] visitedWords;
    static boolean[][] neighborAdjacency;
    static List<String> desiredSubset = new ArrayList<>(); // Which is in fact a cycle in our graph

    public static void main(String[] args) {

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
            if (args[i].length() > 1 || !Character.isLetter(args[i].charAt(0))) {
                System.err.println("The given Alphabet doesn't contain letters only");
                System.exit(0);
            }
        }

        /* Generating words */
        words = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder aux = new StringBuilder();
            for (int j = 0; j < p; j++) {
                aux.append(args[(int) Math.floor(Math.random() * (args.length - 1 - 2 + 1) + 2)]); //Math.floor(Math.random()*(max-min+1)+min)
            }
            words[i] = new String(aux);
        }
        System.out.println("Words: " + Arrays.toString(words) + "\n\n");

        /* Creating a boolean n x n matrix, representing the adjacency relation of the words */
        neighborAdjacency = new boolean[n][n];
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

        /* Finding the desired subset */
        visitedWords = new boolean[n];
        boolean foundSubset = false;
        for (int i = 0; i < n; i++) {
            if (!visitedWords[i]) if (dfs(i, -1)) {
                foundSubset = true;
                break;
            }
        }
        if (foundSubset) {
            while (desiredSubset.get(0) != desiredSubset.get(desiredSubset.size() - 1)) desiredSubset.remove(0);
            System.out.println("Desired subset of words: " + desiredSubset);
        } else {
            System.out.println("Sorry, I didn't find a subset that meets the desired requirements.");
        }

    }

    public static boolean checkNeighbor(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.contains(String.valueOf(s2.charAt(i)))) return true;
        }
        return false;
    }

    public static boolean dfs(int currentWord, int parentWord) {
        visitedWords[currentWord] = true;
        desiredSubset.add(words[currentWord]);

        for (int i = 0; i < visitedWords.length; i++) {
            if (neighborAdjacency[currentWord][i]) if (!visitedWords[i]) {
                return dfs(i, currentWord);
            } else if (i != parentWord && i != currentWord) {
                desiredSubset.add(words[i]);
                return true;
            }
        }
        return false;
    }

}
