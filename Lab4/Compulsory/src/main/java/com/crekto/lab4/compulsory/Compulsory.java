/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.crekto.lab4.compulsory;

import com.crekto.lab4.compulsory.classes.Intersection;
import com.crekto.lab4.compulsory.classes.Street;
import java.util.stream.IntStream;

/**
 *
 * @author hiimC
 */
public class Compulsory {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        var nodes = IntStream.rangeClosed(0, 8).mapToObj(i-> new Intersection("v"+i)).toArray(Intersection[]::new);
        Street s1 = new Street("s1", 2, nodes[0], nodes[1]);
        Street s2 = new Street("s2", 2, nodes[0], nodes[2]);
        Street s3 = new Street("s3", 2, nodes[0], nodes[3]);
        Street s4 = new Street("s4", 2, nodes[1], nodes[2]);
        Street s5 = new Street("s5", 3, nodes[1], nodes[4]);
        Street s6 = new Street("s6", 2, nodes[2], nodes[6]);
        Street s7 = new Street("s7", 2, nodes[2], nodes[5]);
        Street s8 = new Street("s8", 3, nodes[3], nodes[5]);
        Street s9 = new Street("s9", 1, nodes[4], nodes[5]);
        Street s10 = new Street("s10", 1, nodes[4], nodes[7]);
        Street s11 = new Street("s11", 2, nodes[4], nodes[8]);
        Street s12 = new Street("s12", 1, nodes[6], nodes[7]);
        Street s13 = new Street("s13", 1, nodes[6], nodes[8]);
        Street s14 = new Street("s14", 1, nodes[7], nodes[8]);
        Street s15 = new Street("s15", 3, nodes[5], nodes[8]);
        
        
    }
    
    
}
